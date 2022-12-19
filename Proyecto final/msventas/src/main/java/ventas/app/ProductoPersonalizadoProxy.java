package ventas.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ventas.app.dtos.ProductoPersonalizadoDTO;

@FeignClient(name = "productopersonalizado")
public interface ProductoPersonalizadoProxy {

    @GetMapping("/productopersonalizado/{idProdPers}")
    ProductoPersonalizadoDTO buscarPorId(@PathVariable("idProdPers") Long id);

    @GetMapping("/productopersonalizado/{idProdPers}/existe")
    boolean existeProductoPersonalizado(@PathVariable("idProdPers") Long id);
}
