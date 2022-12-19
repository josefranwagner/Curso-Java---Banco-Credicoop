package productopersonalizado.entities;

import javax.persistence.*;

@Entity
@Table(name="Personalizacion")
public class Personalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="precio")
    private double precio;

    @Column(name="id_posible_personalizacion")
    private Long idPosiblePersonalizacion;

    @Column(name="contenido")
    private String contenido;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getIdPosiblePersonalizacion() {
        return idPosiblePersonalizacion;
    }

    public void setIdPosiblePersonalizacion(Long idPosiblePersonalizacion) {
        this.idPosiblePersonalizacion = idPosiblePersonalizacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
