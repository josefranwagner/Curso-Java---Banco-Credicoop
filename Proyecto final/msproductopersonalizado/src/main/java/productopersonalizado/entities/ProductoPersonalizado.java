package productopersonalizado.entities;

import productopersonalizado.app.dtos.ProductoPersonalizadoDTO;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ProductoPersonalizado")
public class ProductoPersonalizado {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "personalizaciones")
    private Set<Personalizacion> personalizaciones;

    @Column(name = "precio_final")
    private double precioFinal;

    @Column(name = "id_producto_base", nullable = false)
    private Long idProductoBase;

    public ProductoPersonalizado(Long id, Long idProductoBase, Set<Personalizacion> personalizaciones, double precioFinal){
        this.id = id;
        this.idProductoBase = idProductoBase;
        this.personalizaciones = personalizaciones;
        this.precioFinal = precioFinal;
    }

    public ProductoPersonalizado() {
        this.personalizaciones = new LinkedHashSet<>();
    }

    public ProductoPersonalizado(ProductoPersonalizadoDTO productoPersonalizadoDTO) {
        this.id = productoPersonalizadoDTO.getId();
        this.idProductoBase = productoPersonalizadoDTO.getIdProductoBase();
        this.personalizaciones = productoPersonalizadoDTO.getPersonalizaciones();
        this.precioFinal = productoPersonalizadoDTO.getPrecioFinal();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProductoBase() {
        return idProductoBase;
    }
    public void setIdProductoBase(Long productoBase) {
        this.idProductoBase = productoBase;
    }

    public Set<Personalizacion> getPersonalizaciones() {
        return personalizaciones;
    }
    public void agregarPersonalizacion(Personalizacion personalizacion) {
        this.personalizaciones.add(personalizacion);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

    public void calcularPrecioFinal(double precioProductoBase){
        double precioPersonalizacion = personalizaciones.stream().mapToDouble(p -> p.getPrecio()).sum();
        double precioFinal = precioPersonalizacion + precioProductoBase;
        setPrecioFinal(precioFinal);
    }
}
