package ventas.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ventas.db.*;
import ventas.entities.*;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class CompraController {

    @Resource
    CarritoDeCompraJPA carritoDeCompraJPA;

    @Resource
    VendedorJPA vendedorJPA;

    @Resource
    CompraJPA compraJPA;

    @Resource
    MedioDePagoJPA medioDePagoJPA;

    @Resource
    TiendaJPA tiendaJPA;

    @Transactional
    @PostMapping("/carrito/{idCarrito}/mediodepago/{idMedioPago}")
    public @ResponseBody ResponseEntity<String> comprarCarrito(@PathVariable("idCarrito") Long idCarrito, @PathVariable("idMedioPago") Long idMedioPago){
        if(carritoDeCompraJPA.existsById(idCarrito)){
            if(medioDePagoJPA.existsById(idMedioPago)){
                Optional<MedioDePago> medioDePagoOptional = medioDePagoJPA.findById(idMedioPago);
                Optional<CarritoDeCompra> carritoDeCompraOptional = carritoDeCompraJPA.findById(idCarrito);
                Optional<Tienda> tiendaOptional = tiendaJPA.findById(carritoDeCompraOptional.get().getItems().get(0).getPublicacion().getIdTiendaAsociada());
                Optional<Vendedor> vendedorOptional = vendedorJPA.findById(tiendaOptional.get().getIdVendedor());

                if(vendedorOptional.get().getMediosDePago().contains(medioDePagoOptional.get())){
                    Compra compra = new Compra(carritoDeCompraOptional.get(), medioDePagoOptional.get(), vendedorOptional.get());
                    compraJPA.save(compra);
                    return new ResponseEntity<>("Compra realizada con éxito - [Monto: " + carritoDeCompraOptional.get().getPrecioFinal() +
                            " - Medio de pago: " + medioDePagoOptional.get().getNombre() + "].", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Medio de pago no aceptado.", HttpStatus.CONFLICT);
                }
            } else {
                return new ResponseEntity<>("No existe medio de pago.", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("No existe el carrito.", HttpStatus.CONFLICT);
        }
    }
}