package ventas.entities;


import ventas.app.dtos.ItemDTO;
import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id")
    private Publicacion publicacion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private double precioFinal;

    public Item(){}

    public Item(Long id, Publicacion publicacion, int cantidad, double precioFinal) {
        this.id = id;
        this.publicacion = publicacion;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
    }

    public Item(ItemDTO itemDTO){
        this.cantidad = itemDTO.getCantidad();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void calcularPrecioFinal(double precioPublicacion){
        this.setPrecioFinal(cantidad * precioPublicacion);
    }
}
