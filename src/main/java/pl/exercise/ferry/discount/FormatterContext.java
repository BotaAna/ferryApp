package pl.exercise.ferry.discount;

import javafx.scene.effect.Light;

import java.math.BigDecimal;

public class FormatterContext {

    private Discounts strategy;

    public void set(Discounts strategy){
        this.strategy = strategy;
    }

    public BigDecimal getBalance() {
        BigDecimal balance = strategy.getBalance();
        return balance;
    }

}
