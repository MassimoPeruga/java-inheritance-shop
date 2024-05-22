package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Product {
    // attributi
    private String imeiCode;
    private int memory;

    // costruttore
    public Smartphone(String name, String description, BigDecimal price, BigDecimal vat, String imeiCode, int memory) {
        super(name, description, price, vat);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }

    // setter
    public void setImeiCode(String imeiCode) {
        this.imeiCode = imeiCode;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    //getter
    public String getImeiCode() {
        return this.imeiCode;
    }

    public int getMemory() {
        return this.memory;
    }

    //methods
    @Override
    public BigDecimal getDiscountedPrice() {
        if (this.memory < 32) {
            return super.getFullPrice().multiply(BigDecimal.valueOf(0.95)).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return super.getDiscountedPrice();
        }
    }
}