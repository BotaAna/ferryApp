package pl.exercise.ferry.ticket.personTicket;

import pl.exercise.ferry.ticket.Ticket;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class PersonTicket implements Ticket {

    Scanner scanner = new Scanner(System.in);


    private PaxType paxType;
    private String owner;
    private String personType;
    private BigDecimal price;

    public PersonTicket(PaxType paxType, String owner) {
        this.paxType = paxType;
        this.owner = owner;
    }

    @Override
    public String getType() {
        return "Person";
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
