package ventas.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "idTiendaAsociada", cascade = CascadeType.ALL)
    //@JoinColumn(name = "tienda_id", referencedColumnName = "id")
    private List<Publicacion> publicaciones;

    @Column(name = "id_vendedor")
    private Long idVendedor;

    public Tienda() {
        this.publicaciones = new ArrayList<>();
    }

    public Tienda(Long idVendedor) {
        this.publicaciones = new ArrayList<>();
        this.idVendedor = idVendedor;
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

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }
}
