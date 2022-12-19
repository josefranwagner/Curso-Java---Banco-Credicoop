package productobase.app;

public class RespuestaStatusDTO {

    private String status;
    private String motivo;

    public RespuestaStatusDTO(){
        super();
    }

    public RespuestaStatusDTO(String status, String motivo) {
        this.status = status;
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}