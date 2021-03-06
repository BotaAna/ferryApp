package pl.exercise.ferry.ticket.cargoTicket;

import javafx.util.converter.BigDecimalStringConverter;
import pl.exercise.ferry.ticket.Ticket;

import java.math.BigDecimal;

public abstract class CargoTicket implements Ticket {

    private final CargoType cargoType;
    private String owner;
    private BigDecimal price;

    public CargoTicket(CargoType cargoType, String owner) {
        this.cargoType = cargoType;
        this.owner = owner;
    }

    @Override
    public String getType() {
        return "Cargo";
    }

    @Override
    public String ownerData() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner=owner;
    }

    @Override
    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

}
