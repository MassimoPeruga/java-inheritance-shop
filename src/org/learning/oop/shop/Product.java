package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    // Attributi
    private final int code;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;

    // Costruttore
    public Product(String name, String description, BigDecimal price, BigDecimal vat) {
        this.code = new Random().nextInt(1,1000);
        this.name = valueOrDefault(name);
        this.description = valueOrDefault(description);
        this.price = valueOrDefault(price);
        this.vat = valueOrDefault(vat);
    }

    // Setter
    public void setName(String name) {
        this.name = valueOrDefault(name);
    }

    public void setDescription(String description) {
        this.description = valueOrDefault(description);
    }


    public void setPrice(BigDecimal price) {
        this.price = valueOrDefault(price);
    }


    public void setVat(BigDecimal vat) {
        this.vat = valueOrDefault(vat);
    }

    // Getter
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

    public BigDecimal getFullPrice() {
        BigDecimal vatAmount = price.multiply(vat.divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN));
        return price.add(vatAmount).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getFullName() {
        return getCode() + "-" + this.name;
    }

    // Methods
    private String valueOrDefault(String value){
        if(value == null || value.isEmpty()){
            return "N.D.";
        }
        return value;
    }

    private BigDecimal valueOrDefault(BigDecimal value){
        if(value == null || value.compareTo(BigDecimal.ZERO) < 0){
            return BigDecimal.ZERO;
        }
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getDiscountedPrice() {
        return getFullPrice().multiply(BigDecimal.valueOf(0.98)).setScale(2, RoundingMode.HALF_EVEN);
    }
}