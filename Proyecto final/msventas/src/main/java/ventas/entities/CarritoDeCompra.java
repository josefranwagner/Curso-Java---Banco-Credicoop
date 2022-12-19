package ventas.entities;

/*import org.hibernate.engine.internal.Cascade;*/
import ventas.app.dtos.CarritoDeCompraDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "CarritoDeCompra")
public class CarritoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprador_id", referencedColumnName = "id")
    private Comprador comprador;

    @ManyToMany
    private List<Item> items;

    @Column(name = "precioFinal")
    private double precioFinal;

    public CarritoDeCompra(){
        this.items = new ArrayList<>();
    }

    public CarritoDeCompra(CarritoDeCompraDTO carritoDeCompraDTO){
        this.comprador = carritoDeCompraDTO.getComprador();
        this.items = new ArrayList<>();
        this.precioFinal = 0;
    }

    public CarritoDeCompra(Optional<CarritoDeCompra> optionalCarritoDeCompra){
        this.id = optionalCarritoDeCompra.get().getId();
        this.comprador = optionalCarritoDeCompra.get().getComprador();
        this.items = optionalCarritoDeCompra.get().getItems();
        this.precioFinal = optionalCarritoDeCompra.get().getPrecioFinal();
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }
    public void agregarItem(Item item) {
        this.items.add(item);
        this.calcularPrecioFinal();
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void calcularPrecioFinal(){
        double precio = items.stream().mapToDouble(e -> e.getPrecioFinal()).sum();
        this.setPrecioFinal(precio);
    }
}
