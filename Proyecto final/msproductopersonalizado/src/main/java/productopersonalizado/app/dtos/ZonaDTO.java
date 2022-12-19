package productopersonalizado.app.dtos;

public class ZonaDTO {
    private Long id;

    private String nombre;

    public ZonaDTO(){ }

    public ZonaDTO(String nombre){
        this.nombre = nombre;
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
}
