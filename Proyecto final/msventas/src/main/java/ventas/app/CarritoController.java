package ventas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ventas.app.dtos.CarritoDeCompraDTO;
import ventas.db.CarritoDeCompraJPA;
import ventas.entities.CarritoDeCompra;

import javax.transaction.Transactional;

@RestController
public class CarritoController {

    @Autowired
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Transactional
    @PostMapping("/carrito")
    public @ResponseBody ResponseEntity<String> generarCarrito(@RequestBody CarritoDeCompraDTO carritoDeCompraDTO){
        CarritoDeCompra carritoDeCompra = new CarritoDeCompra(carritoDeCompraDTO);
        carritoDeCompraJPA.save(carritoDeCompra);
        return new ResponseEntity<>("Se creó el carrito de compras", HttpStatus.OK);
    }

}
