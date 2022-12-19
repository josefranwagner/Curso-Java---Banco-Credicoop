package ventas.entities;


import ventas.app.dtos.PublicacionDTO;
import ventas.converters.LocalDateAttributeConverter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Entity
@Table(name="Publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="id_producto_personalizado")
    private Long idProductoPersonalizado;

    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoPublicacion estadoPublicacion;

    @Column(name="hora_de_subida")
    private LocalTime horaDeSubida;

    @Column(name="hora_de_baja")
    private LocalTime horaDeBaja;

    @Column(name="fecha_de_subida")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaDeSubida;

    @Column(name="fecha_de_baja")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate fechaDeBaja;

    @Column(name="precio")
    private double precio;

    @Column(name="id_tienda_asociada")
    private Long idTiendaAsociada;

    public Publicacion(){ }

    public Publicacion(PublicacionDTO publicacionDTO){
        this.id = publicacionDTO.getId();
        this.idProductoPersonalizado = publicacionDTO.getIdProductoPersonalizado();
        this.estadoPublicacion = EstadoPublicacion.ACTIVA;
        this.horaDeSubida = publicacionDTO.getHoraActual();
        this.fechaDeSubida = publicacionDTO.getFechaActual();
        this.fechaDeBaja = null;
        this.horaDeBaja = null;
        this.idTiendaAsociada = this.getIdTiendaAsociada();
    }

    public Publicacion(Optional<Publicacion> optionalPublicacion){
        this.id = optionalPublicacion.get().getId();
        this.idProductoPersonalizado = optionalPublicacion.get().getIdProductoPersonalizado();
        this.estadoPublicacion = optionalPublicacion.get().getEstadoPublicacion();
        this.horaDeSubida = optionalPublicacion.get().getHoraDeSubida();
        this.fechaDeSubida = optionalPublicacion.get().getFechaDeSubida();
        this.fechaDeBaja = optionalPublicacion.get().getFechaDeBaja();
        this.horaDeBaja = optionalPublicacion.get().getHoraDeBaja();
        this.idTiendaAsociada = optionalPublicacion.get().getIdTiendaAsociada();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProductoPersonalizado() {
        return idProductoPersonalizado;
    }

    public void setIdProductoPersonalizado(Long idProductoPersonalizado) {
        this.idProductoPersonalizado = idProductoPersonalizado;
    }

    public EstadoPublicacion getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(EstadoPublicacion estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public LocalTime getHoraDeSubida() {
        return horaDeSubida;
    }

    public void setHoraDeSubida(LocalTime horaDeSubida) {
        this.horaDeSubida = horaDeSubida;
    }

    public LocalTime getHoraDeBaja() {
        return horaDeBaja;
    }

    public void setHoraDeBaja(LocalTime horaDeBaja) {
        this.horaDeBaja = horaDeBaja;
    }

    public LocalDate getFechaDeSubida() {
        return fechaDeSubida;
    }

    public void setFechaDeSubida(LocalDate fechaDeSubida) {
        this.fechaDeSubida = fechaDeSubida;
    }

    public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public Long getIdTiendaAsociada() {
        return idTiendaAsociada;
    }

    public void setIdTiendaAsociada(Long idTiendaAsociada) {
        this.idTiendaAsociada = idTiendaAsociada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void pausarPublicacion(){
        this.setEstadoPublicacion(EstadoPublicacion.PAUSADA);
    }

    public void activarPublicacion(){
        this.setEstadoPublicacion(EstadoPublicacion.ACTIVA);
        this.setFechaDeBaja(null);
        this.setHoraDeBaja(null);
    }

    public boolean sePuedeComprar(){
        return this.getEstadoPublicacion() == EstadoPublicacion.ACTIVA;
    }

    public LocalDate getFechaActual(){ return LocalDate.now(); }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }
}
