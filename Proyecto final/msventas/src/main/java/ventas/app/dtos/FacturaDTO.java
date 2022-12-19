package ventas.app.dtos;


import ventas.entities.CarritoDeCompra;
import ventas.entities.Comprador;
import ventas.entities.MedioDePago;

public class FacturaDTO {

    public double importe;
    public Comprador datosComprador;
    public CarritoDeCompra carrito;
    public MedioDePago medioDePago;

    public FacturaDTO() {
    }

    public FacturaDTO(double importe, CarritoDeCompra carrito, MedioDePago medioDePago, Comprador datosComprador) {
        this.importe = importe;
        this.carrito = carrito;
        this.medioDePago = medioDePago;
        this.datosComprador = datosComprador;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public CarritoDeCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompra carrito) {
        this.carrito = carrito;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }
}
