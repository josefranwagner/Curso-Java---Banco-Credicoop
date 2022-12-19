package productopersonalizado.app.dtos;

public class PosiblePersonalizacionDTO {

    private Long id;
    private ZonaDTO zona;
    private TipoDTO tipo;

    public PosiblePersonalizacionDTO(ZonaDTO zona) {
        this.zona = zona;
    }

    public PosiblePersonalizacionDTO() { }

    public PosiblePersonalizacionDTO(ZonaDTO zona, TipoDTO tipo) {
        this.zona = zona;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonaDTO getZona() {
        return zona;
    }

    public void setZona(ZonaDTO zona) {
        this.zona = zona;
    }

    public TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoDTO tipo) {
        this.tipo = tipo;
    }
}
