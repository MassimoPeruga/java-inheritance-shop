package org.learning.oop.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    // attributi
    private List<Product> products;

    // costruttore
    public Cart() {
        this.products = new ArrayList<>();
    }

    //methods
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public BigDecimal getTotal(boolean hasLoyaltyCard) {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : this.products) {
            total = total.add(hasLoyaltyCard ? product.getDiscountedPrice() : product.getPriceWithVat());
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : this.products) {
            sb.append(product.getExtendedName()).append(", ").append(product.getDescription()).append(", ").append(product.getPriceWithVat()).append("\n");
        }
        return sb.toString();
    }
}