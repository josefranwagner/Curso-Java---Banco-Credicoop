package productobase.app.dtos;

import productobase.entities.Tipo;
import productobase.entities.Zona;

public class PosiblePersonalizacionDTO {
    private Long id;

    private Zona zona;

    private Tipo tipo;

    public PosiblePersonalizacionDTO(Zona zona) {
        this.zona = zona;
    }

    public PosiblePersonalizacionDTO() { }

    public PosiblePersonalizacionDTO(Zona zona, Tipo tipo) {
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

