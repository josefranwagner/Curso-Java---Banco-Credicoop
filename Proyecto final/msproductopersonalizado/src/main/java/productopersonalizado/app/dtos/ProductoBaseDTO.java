package productopersonalizado.app.dtos;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductoBaseDTO {

    private Long id;
    private String nombre;
    private double precioBase;
    private String descripcion;
    private int tiempoEstimadoDeFabricacion;
    private Set<PosiblePersonalizacionDTO> posiblesPersonalizaciones;

    public ProductoBaseDTO() {
        this.posiblesPersonalizaciones = new LinkedHashSet<>();
    }

    public ProductoBaseDTO(Long id, String nombre, double precioBase, String descripcion, int tiempoEstimadoDeFabricacion, Set<PosiblePersonalizacionDTO> posiblesPersonalizaciones) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
        this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion;
        this.posiblesPersonalizaciones = posiblesPersonalizaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoEstimadoDeFabricacion() {
        return tiempoEstimadoDeFabricacion;
    }

    public void setTiempoEstimadoDeFabricacion(int tiempoEstimadoDeFabricacion) {
        this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion;
    }

    public Set<PosiblePersonalizacionDTO> getPosiblesPersonalizaciones() {
        return posiblesPersonalizaciones;
    }

    public void setPosiblesPersonalizaciones(Set<PosiblePersonalizacionDTO> posiblesPersonalizaciones) {
        this.posiblesPersonalizaciones = posiblesPersonalizaciones;
    }

    public void agregarPosiblesPersonalizaciones(PosiblePersonalizacionDTO posiblePersonalizacion) {
        this.posiblesPersonalizaciones.add(posiblePersonalizacion);
    }

}
