package pl.exercise.ferry.discount;

import pl.exercise.ferry.Basket;
import pl.exercise.ferry.ticket.Ticket;

import java.math.BigDecimal;
import java.util.List;

public class LogicOfDiscounts {

    FormatterContext context = new FormatterContext();

    public BigDecimal getBalance() {
        List<Ticket> tickets = Basket.INSTANCE.listOfTickets();
        int a = 0;
        int b = 0;
        int c = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getSubType().equals("Adult")) a++;
            if (ticket.getSubType().equals("Child")) b++;
            if (ticket.getSubType().equals("Young")) c++;
        }
        if (a > 0 && (b+c) > 0){
            context.set(new Discounts1());
        }

        return context.getBalance();
    }
}
