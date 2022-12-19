package ventas.app.dtos;

import java.util.ArrayList;
import java.util.List;

public class TiendaDTO {

    private Long id;
    private String nombre;
    private List<PublicacionDTO> publicaciones;

    public TiendaDTO() {
        this.publicaciones = new ArrayList<>();
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

    public List<PublicacionDTO> getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(List<PublicacionDTO> publicaciones) { this.publicaciones = publicaciones; }

    public void agregarPublicacion(PublicacionDTO publicacion) {
        this.publicaciones.add(publicacion);
    }
}