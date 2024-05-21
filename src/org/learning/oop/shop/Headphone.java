package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Headphone extends Product {
    // attributi
    private String color;
    private boolean isWireless;

    // costruttore
    public Headphone(String name, String description, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        super(name, description, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }

    // setter
    public void setColor(String color) {
        this.color = color;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    //getter
    public String getColor() {
        return this.color;
    }

    public boolean getIsWireless() {
        return this.isWireless;
    }

    //methods
    @Override
    public BigDecimal getDiscountedPrice() {
        if (!this.isWireless) {
            return super.getPrice().multiply(BigDecimal.valueOf(0.93)).setScale(2, RoundingMode.HALF_UP);
        } else {
            return super.getDiscountedPrice();
        }
    }
}