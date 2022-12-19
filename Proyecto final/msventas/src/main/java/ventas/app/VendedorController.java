package ventas.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ventas.app.dtos.FacturaDTO;
import ventas.app.dtos.VendedorDTO;
import ventas.db.CompraJPA;
import ventas.db.VendedorJPA;
import ventas.entities.Compra;
import ventas.entities.Vendedor;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class VendedorController {

    @Resource
    VendedorJPA vendedorJPA;

    @Resource
    CompraJPA compraJPA;

    @Transactional
    @PostMapping("/vendedor")
    public @ResponseBody ResponseEntity<String> generarVendedor(@RequestBody VendedorDTO vendedorDTO){
        Vendedor vendedor = new Vendedor(vendedorDTO);
        vendedorJPA.save(vendedor);
        return new ResponseEntity<>("Vendedor/a " + vendedor.getNombre() + " " + vendedor.getApellido() + " - ID: " + vendedor.getId() + " dado de alta.", HttpStatus.OK);
    }

    @GetMapping("/vendedor/compra/{idCompra}/generarfactura")
    public @ResponseBody FacturaDTO generarFactura(@PathVariable("idCompra") Long id) throws Exception {
        if(compraJPA.existsById(id)){
            Optional<Compra> compraOptional = compraJPA.findById(id);
            Compra compra = new Compra(compraOptional);
            compra.generarFactura();
            compraJPA.save(compra);
            FacturaDTO facturaDTO = new FacturaDTO(compraOptional.get().getCarritoDeCompra().getPrecioFinal(), compraOptional.get().getCarritoDeCompra(), compraOptional.get().getFormaDePago(), compraOptional.get().getCarritoDeCompra().getComprador());
            return facturaDTO;
        } else {
            throw new Exception("No existe el id compra (" + id + ") para generar factura.");
        }
    }

    public ResponseEntity<String> noDisponible (Exception exception){ return new ResponseEntity<>("No disponible", HttpStatus.CONFLICT); }
    public ResponseEntity<String> noDisponible (IllegalStateException exception){ return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.CONFLICT); }

}
