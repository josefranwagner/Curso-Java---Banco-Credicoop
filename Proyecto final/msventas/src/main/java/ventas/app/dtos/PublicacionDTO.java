package ventas.app.dtos;

import ventas.entities.EstadoPublicacion;
import java.time.LocalDate;
import java.time.LocalTime;

public class PublicacionDTO {

    private Long id;
    private Long idProductoPersonalizado;
    private EstadoPublicacion estadoPublicacion;

    public PublicacionDTO(){}

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

    public LocalDate getFechaActual(){
        return LocalDate.now();
    }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }

}
