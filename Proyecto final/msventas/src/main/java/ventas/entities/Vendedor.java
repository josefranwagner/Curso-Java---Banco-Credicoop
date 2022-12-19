package ventas.entities;

import ventas.app.dtos.VendedorDTO;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="Vendedor")
public class Vendedor {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MedioDePago> mediosDePago;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tienda_id", referencedColumnName = "id")
    private Tienda tienda;

    public Vendedor(){
        this.mediosDePago = new LinkedHashSet<>();
    }

    public Vendedor(VendedorDTO vendedorDTO) {
        this.id = vendedorDTO.getId();
        this.nombre = vendedorDTO.getNombre();
        this.apellido = vendedorDTO.getApellido();
        this.mediosDePago = vendedorDTO.getMediosDePago();
        this.crearTienda();
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMediosDePago(Set<MedioDePago> mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    public Set<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }
    public void agregarMedioDePago(MedioDePago medioDePago) { this.mediosDePago.add(medioDePago);}

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void crearTienda(){
        Tienda tienda = new Tienda();
        tienda.setNombre("Tienda de " + this.getNombre());
        tienda.setIdVendedor(this.getId());
        this.setTienda(tienda);
    }
}
