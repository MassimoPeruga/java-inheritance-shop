package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    // attributi
    private int code;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;

    // costruttore
    public Product(String name, String description, BigDecimal price, BigDecimal vat) {
        this.code = new Random().nextInt(999999);
        this.name = name;
        this.description = description;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.vat = vat;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //getter
    public String getCode() {
        return String.format("%06d", this.code);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getVat() {
        return this.vat;
    }

    //methods
    public BigDecimal getBasePrice() {
        return this.price;
    }

    public BigDecimal getPriceWithVat() {
        return this.price.multiply(this.vat.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE)).setScale(2, RoundingMode.HALF_UP);
    }

    public String getExtendedName() {
        return getCode() + "-" + this.name;
    }

    public BigDecimal getDiscountedPrice() {
        return this.price.multiply(BigDecimal.valueOf(0.98)).setScale(2, RoundingMode.HALF_UP);
    }
}