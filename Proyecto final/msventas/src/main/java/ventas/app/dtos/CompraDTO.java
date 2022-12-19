package ventas.app.dtos;

import ventas.entities.Item;
import ventas.entities.MedioDePago;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CompraDTO {

    private MedioDePago formaDePago;
    private List<Item> items;

    public CompraDTO (){

    }

    public MedioDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(MedioDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public LocalDate getFechaActual(){ return LocalDate.now(); }

    public LocalTime getHoraActual(){
        return LocalTime.now();
    }

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) { this.items = items; }
    public void agregarItems(Item item) {
        this.items.add(item);
    }

}
