package productopersonalizado.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productopersonalizado.app.dtos.ProductoBaseDTO;
import productopersonalizado.app.dtos.ProductoPersonalizadoDTO;
import productopersonalizado.db.ProductoPersonalizadoJPA;
import productopersonalizado.entities.ProductoPersonalizado;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ProductoPersonalizadoController {

    @Autowired
    ProductoBaseProxy proxy;

    @Resource
    ProductoPersonalizadoJPA productoPersonalizadoJPA;

    @Transactional
    @PostMapping("/productopersonalizado/")
    public @ResponseBody ResponseEntity<String> crearProductoPersonalizado(@RequestBody ProductoPersonalizadoDTO productoPersonalizadoDTO){
        if(!productoPersonalizadoJPA.existsById(productoPersonalizadoDTO.getId())){
            boolean existeProductoBase = proxy.existeProductoBase(productoPersonalizadoDTO.getIdProductoBase());
            if(existeProductoBase) {
                ProductoBaseDTO productoBaseAsociado = proxy.buscarPorId(productoPersonalizadoDTO.getIdProductoBase());
                boolean sePuedePersonalizar = productoPersonalizadoDTO.getPersonalizaciones().stream().allMatch(e -> proxy.existePosiblePersonalizacion(e.getIdPosiblePersonalizacion()));
                if(sePuedePersonalizar){
                    ProductoPersonalizado producto = new ProductoPersonalizado(productoPersonalizadoDTO);
                    producto.calcularPrecioFinal(productoBaseAsociado.getPrecioBase());
                    productoPersonalizadoJPA.save(producto);
                    return new ResponseEntity<>("Se agregó el producto personalizado - (ID: " + productoPersonalizadoDTO.getId() + ").", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("La personalización (ID: " + productoPersonalizadoDTO.getId() + ") no es posible." , HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("No existe el producto base." , HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("ID Duplicado.", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/productopersonalizado/{idProdPers}")
    public ProductoPersonalizadoDTO buscarPorId(@PathVariable("idProdPers") Long id){
        Optional<ProductoPersonalizado> productoPersonalizado = productoPersonalizadoJPA.findById(id);
        ProductoPersonalizadoDTO productoPersonalizadoDTO = new ProductoPersonalizadoDTO(productoPersonalizado);
        return productoPersonalizadoDTO;
    }

    @GetMapping("/productopersonalizado/{idProdPers}/existe")
    public boolean existeProductoPersonalizado(@PathVariable("idProdPers") Long id){
        return productoPersonalizadoJPA.existsById(id);
    }

}
