package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TV extends Product {
    // attributi
    private int size;
    private boolean isSmart;

    // costruttore
    public TV(String name, String description, BigDecimal price, BigDecimal vat, int size, boolean isSmart) {
        super(name, description, price, vat);
        this.size = size;
        this.isSmart = isSmart;
    }

    // setter
    public void setSize(int size) {
        this.size = size;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    //getter
    public int getSize() {
        return this.size;
    }

    public boolean getIsSmart() {
        return this.isSmart;
    }

    //methods
    @Override
    public BigDecimal getDiscountedPrice() {
        if (!this.isSmart) {
            return super.getPrice().multiply(BigDecimal.valueOf(0.90)).setScale(2, RoundingMode.HALF_UP);
        } else {
            return super.getDiscountedPrice();
        }
    }
}