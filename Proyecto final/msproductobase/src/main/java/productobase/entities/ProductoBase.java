package productobase.entities;


import productobase.app.dtos.ProductoBaseDTO;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="producto_base")
public class ProductoBase {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="precio_base")
    private double precioBase;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="tiempo_estimado_de_fabricacion")
    private int tiempoEstimadoDeFabricacion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name="posibles_personalizaciones")
    private Set<PosiblePersonalizacion> posiblesPersonalizaciones;

    public ProductoBase(String nombre) {
        this.nombre = nombre;
    }

    public ProductoBase(Long id, String nombre, double precioBase, String descripcion, int tiempoEstimadoDeFabricacion, Set<PosiblePersonalizacion> posiblesPersonalizaciones) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
        this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion;
        this.posiblesPersonalizaciones = posiblesPersonalizaciones;
    }

    public ProductoBase(ProductoBaseDTO productoBaseDTO) {
        this.id = productoBaseDTO.getId();
        this.nombre = productoBaseDTO.getNombre();
        this.precioBase = productoBaseDTO.getPrecioBase();
        this.descripcion = productoBaseDTO.getDescripcion();
        this.tiempoEstimadoDeFabricacion = productoBaseDTO.getTiempoEstimadoDeFabricacion();
        this.posiblesPersonalizaciones = productoBaseDTO.getPosiblesPersonalizaciones();
    }

    public ProductoBase() {
        this.posiblesPersonalizaciones = new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getTiempoEstimadoDeFabricacion() { return tiempoEstimadoDeFabricacion; }
    public void setTiempoEstimadoDeFabricacion(int tiempoEstimadoDeFabricacion) { this.tiempoEstimadoDeFabricacion = tiempoEstimadoDeFabricacion; }

    public Set<PosiblePersonalizacion> getPosiblesPersonalizaciones() { return posiblesPersonalizaciones; }
    public void setPosiblesPersonalizaciones(Set<PosiblePersonalizacion> posiblesPersonalizaciones) {
        this.posiblesPersonalizaciones = posiblesPersonalizaciones;
    }

    public void agregarPosiblePersonalizacion(PosiblePersonalizacion posiblePersonalizacion) { this.posiblesPersonalizaciones.add(posiblePersonalizacion); }

}
