package ventas.app.dtos;

import ventas.entities.MedioDePago;
import java.util.LinkedHashSet;
import java.util.Set;

public class VendedorDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Set<MedioDePago> mediosDePago;

    public VendedorDTO(){
        this.mediosDePago = new LinkedHashSet<>();
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

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Set<MedioDePago> getMediosDePago() {
        return mediosDePago;
    }
    public void setMediosDePago(Set<MedioDePago> mediosDePago) { this.mediosDePago = mediosDePago; }
    public void agregarMedioDePago(MedioDePago medioDePago) { this.mediosDePago.add(medioDePago);}
}
