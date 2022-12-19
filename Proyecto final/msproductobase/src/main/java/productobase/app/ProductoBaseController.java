package productobase.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productobase.app.dtos.ProductoBaseDTO;
import productobase.db.ProductoBaseJPA;
import productobase.entities.ProductoBase;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class ProductoBaseController {

    @Value("${server.port}")
    private String puerto;

    @Autowired
    ProductoBaseJPA productoBaseJPA;

    @Transactional
    @PostMapping("/productobase/")
    public @ResponseBody ResponseEntity<String> agregarProductoBase(@RequestBody ProductoBaseDTO productoBaseDTO){
        if(!productoBaseJPA.existsById(productoBaseDTO.getId())){
            ProductoBase producto = new ProductoBase(productoBaseDTO);
            productoBaseJPA.save(producto);
            return new ResponseEntity<>("Se ha agregado el producto: " + productoBaseDTO.getNombre() + " - (Puerto: " + puerto + ").", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El ID del producto ya existe", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/productobase/{idProdBase}")
    public ProductoBaseDTO buscarPorId(@PathVariable("idProdBase") Long id){
        Optional<ProductoBase> productoBase = productoBaseJPA.findById(id);
        ProductoBaseDTO productoBaseDTO = new ProductoBaseDTO(productoBase);
        return productoBaseDTO;
    }

    @GetMapping("/productobase/{idProdBase}/existe")
    public boolean existeProductoBase(@PathVariable("idProdBase") Long id){
        return productoBaseJPA.existsById(id);
    }
}
