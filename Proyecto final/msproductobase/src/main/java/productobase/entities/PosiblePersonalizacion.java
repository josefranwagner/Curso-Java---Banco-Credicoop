package productobase.entities;

import javax.persistence.*;

@Entity
@Table(name="PosiblePersonalizacion")
public class PosiblePersonalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zona_id", referencedColumnName = "id")
    private Zona zona;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private Tipo tipo;

    public PosiblePersonalizacion(Zona zona) {
        this.zona = zona;
    }

    public PosiblePersonalizacion() { }

    public PosiblePersonalizacion(Zona zona, Tipo tipo) {
        this.zona = zona;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
