package ventas.app.dtos;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoPersonalizadoDTO {

    private Long id;
    private Long idProductoBase;
    private Set<PersonalizacionDTO> personalizaciones;
    private double precioFinal;

    public ProductoPersonalizadoDTO(Long id, Long idProductoBase, Set<PersonalizacionDTO> personalizaciones, double precioFinal){
        this.id = id;
        this.idProductoBase = idProductoBase;
        this.personalizaciones = personalizaciones;
        this.precioFinal = precioFinal;
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

    public Set<PersonalizacionDTO> getPersonalizaciones() {
        return personalizaciones;
    }
    public void setPersonalizaciones(Set<PersonalizacionDTO> personalizaciones) { this.personalizaciones = personalizaciones; }

    public void agregarPersonalizacion(PersonalizacionDTO personalizacion) {
        this.personalizaciones.add(personalizacion);
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) { this.precioFinal = precioFinal; }

}
