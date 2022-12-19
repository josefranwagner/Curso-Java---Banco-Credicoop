package ventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ventas.app.dtos.ProductoPersonalizadoDTO;
import ventas.app.dtos.PublicacionDTO;
import ventas.db.PublicacionJPA;
import ventas.db.TiendaJPA;
import ventas.entities.Publicacion;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class PublicacionController {

    @Autowired
    ProductoPersonalizadoProxy proxy;

    @Resource
    PublicacionJPA publicacionJPA;

    @Resource
    TiendaJPA tiendaJPA;

    @Transactional
    @PostMapping("/crearpublicacion/{idTienda}")
    public @ResponseBody ResponseEntity<String> crearPublicacion(@RequestBody PublicacionDTO publicacionDTO, @PathVariable("idTienda") Long id){
        if(tiendaJPA.existsById(id)){
            boolean existeProductoPersonalizado = proxy.existeProductoPersonalizado(publicacionDTO.getIdProductoPersonalizado());
            if(existeProductoPersonalizado) {
                Publicacion publicacion = new Publicacion(publicacionDTO);

                ProductoPersonalizadoDTO productoPersonalizadoDTO = proxy.buscarPorId(publicacionDTO.getIdProductoPersonalizado());

                publicacion.setIdTiendaAsociada(id);
                publicacion.setPrecio(productoPersonalizadoDTO.getPrecioFinal());

                publicacionJPA.save(publicacion);

                return new ResponseEntity<>("Publicación (ID: " + publicacion.getId() + ") creada en " + tiendaJPA.findById(id).get().getNombre() + "." , HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No existe el producto" , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("La tienda no existe", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @PostMapping("/publicacion/{idPublicacion}/pausar")
    public @ResponseBody ResponseEntity<String> pausarPublicacion(@PathVariable("idPublicacion") Long id){
        if(publicacionJPA.existsById(id)){
            Optional<Publicacion> publicacionOptional = publicacionJPA.findById(id);
            Publicacion publicacion = new Publicacion(publicacionOptional);
            publicacion.pausarPublicacion();
            publicacionJPA.save(publicacion);
            return new ResponseEntity<>("Publicación (ID " + publicacion.getId() + ") pausada." , HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la publicación.", HttpStatus.CONFLICT);
        }
    }
}
