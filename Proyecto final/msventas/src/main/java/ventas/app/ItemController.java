package ventas.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ventas.app.dtos.ItemDTO;
import ventas.db.CarritoDeCompraJPA;
import ventas.db.ItemJPA;
import ventas.db.PublicacionJPA;
import ventas.entities.CarritoDeCompra;
import ventas.entities.Item;
import ventas.entities.Publicacion;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ItemController {

    @Resource
    ItemJPA itemJPA;

    @Resource
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Resource
    PublicacionJPA publicacionJPA;

    @Transactional
    @PostMapping("/carrito/{idCarrito}/{idPublicacion}")
    public @ResponseBody ResponseEntity<String> agregarACarrito(@RequestBody ItemDTO itemDTO, @PathVariable("idCarrito") Long idCarrito, @PathVariable("idPublicacion") Long idPublicacion){
        if(carritoDeCompraJPA.existsById(idCarrito)){
            if(publicacionJPA.existsById(idPublicacion)){
                Optional<Publicacion> optionalPublicacion = publicacionJPA.findById(idPublicacion);
                if(optionalPublicacion.get().sePuedeComprar()){
                    Item item = new Item(itemDTO);

                    Publicacion publicacion = new Publicacion(optionalPublicacion);

                    item.setPublicacion(publicacion);

                    Optional<CarritoDeCompra> optionalCarritoDeCompra = carritoDeCompraJPA.findById(idCarrito);
                    CarritoDeCompra carritoDeCompra = new CarritoDeCompra(optionalCarritoDeCompra);

                    item.calcularPrecioFinal(optionalPublicacion.get().getPrecio());
                    itemJPA.save(item);

                    carritoDeCompra.agregarItem(item);

                    carritoDeCompraJPA.save(carritoDeCompra);
                    return new ResponseEntity<>("Se agregó el item al carrito de " + carritoDeCompra.getComprador().getNombre() + " " + carritoDeCompra.getComprador().getApellido() + ".", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("La publicación no se encuentra activa - (Estado actual: " + optionalPublicacion.get().getEstadoPublicacion() + ").", HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("No existe la publicación.", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No existe el carrito.", HttpStatus.CONFLICT);
        }
    }
}