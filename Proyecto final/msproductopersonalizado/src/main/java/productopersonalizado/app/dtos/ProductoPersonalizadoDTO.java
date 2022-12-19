package productopersonalizado.app.dtos;

import productopersonalizado.entities.Personalizacion;
import productopersonalizado.entities.ProductoPersonalizado;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class ProductoPersonalizadoDTO {

    private Long id;
    private Long idProductoBase;
    private Set<Personalizacion> personalizaciones;
    private double precioFinal;

    public ProductoPersonalizadoDTO(Long id, Long idProductoBase, Set<Personalizacion> personalizaciones, double precioFinal){
        this.id = id;
        this.idProductoBase = idProductoBase;
        this.personalizaciones = personalizaciones;
        this.precioFinal = precioFinal;
    }

    public ProductoPersonalizadoDTO(Optional<ProductoPersonalizado> productoPersonalizado){
        this.id = productoPersonalizado.get().getId();
        this.idProductoBase = productoPersonalizado.get().getIdProductoBase();
        this.personalizaciones = productoPersonalizado.get().getPersonalizaciones();
        this.precioFinal = productoPersonalizado.get().getPrecioFinal();
    }

    public ProductoPersonalizadoDTO() {
        this.personalizaciones = new LinkedHashSet<>();
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
    public void setPersonalizaciones(Set<Personalizacion> personalizaciones) { this.personalizaciones = personalizaciones; }

    public void agregarPersonalizacion(Personalizacion personalizacion) {
        this.personalizaciones.add(personalizacion);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

}