package ventas.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="MedioDePago")
public class MedioDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Vendedor> vendedor;

    public MedioDePago(){
        this.vendedor = new LinkedHashSet<>();
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

    public Set<Vendedor> getVendedor() {
        return vendedor;
    }

    public void setVendedor(Set<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }
}
