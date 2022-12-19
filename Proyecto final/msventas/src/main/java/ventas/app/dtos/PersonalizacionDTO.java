package ventas.app.dtos;

public class PersonalizacionDTO {

    private Long id;
    private String nombre;
    private double precio;
    private Long idPosiblePerzonalizacion;
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

    public Long getIdPosiblePerzonalizacion() {
        return idPosiblePerzonalizacion;
    }

    public void setIdPosiblePerzonalizacion(Long idPosiblePerzonalizacion) {
        this.idPosiblePerzonalizacion = idPosiblePerzonalizacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
