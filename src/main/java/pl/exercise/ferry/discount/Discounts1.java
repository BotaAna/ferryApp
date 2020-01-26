package pl.exercise.ferry.discount;

import pl.exercise.ferry.Basket;
import pl.exercise.ferry.ticket.Ticket;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

//Osoba dorosła i dziecko do 18 roku życia - 20% zniżki na oba bilety
public class Discounts1 implements Discounts {
//if subtype  == Adult && Child || Young
//        //return getbalance - 20%.

    @Override
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

        BigDecimal balance = Basket.INSTANCE.getBalance();
        if (a <= (b + c)) {
            balance = balance.subtract(BigDecimal.valueOf(a * 10 * 0.2)).subtract(BigDecimal.valueOf(a * 5 * 0.2));
        }

        if (a > (b + c)) {
            balance = balance.subtract(BigDecimal.valueOf((b + c) * 10 * 0.2)).subtract(BigDecimal.valueOf((b + c) * 5 * 0.2));
        }

        return balance;
    }

}











//    @Override
//    public void discount(listOfTicket) {
//
//        //if subtype  == Adult && Child || Young
//        //return getbalance - 20%.
//
//    }
