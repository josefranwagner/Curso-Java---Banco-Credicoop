package productopersonalizado.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import productopersonalizado.app.dtos.ProductoBaseDTO;

@FeignClient(name = "productobase")
public interface ProductoBaseProxy {

    @GetMapping("/productobase/{idProdBase}")
    ProductoBaseDTO buscarPorId(@PathVariable("idProdBase") Long id);

    @GetMapping("/productobase/{idProdBase}/existe")
    boolean existeProductoBase(@PathVariable("idProdBase") Long id);

    @GetMapping("/posiblepersonalizacion/{idPosiblePersonalizacion}")
    boolean existePosiblePersonalizacion(@PathVariable("idPosiblePersonalizacion") Long id);
}
