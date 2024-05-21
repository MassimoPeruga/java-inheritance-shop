package org.learning.oop.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("What product are you adding? 1: Smartphone, 2: TV, 3: Headphones, 4: Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            if (choice == 4) {
                break;
            }
            System.out.println("Enter the product name:");
            String name = scanner.nextLine();
            System.out.println("Enter the product description:");
            String description = scanner.nextLine();
            System.out.println("Enter the product price:");
            BigDecimal price = scanner.nextBigDecimal();
            System.out.println("Enter the product VAT:");
            BigDecimal vat = scanner.nextBigDecimal();
            scanner.nextLine(); // consume the newline
            if (choice == 1) {
                System.out.println("Enter the IMEI code:");
                String imeiCode = scanner.nextLine();
                System.out.println("Enter the memory quantity:");
                int memory = scanner.nextInt();
                cart.addProduct(new Smartphone(name, description, price, vat, imeiCode, memory));
            } else if (choice == 2) {
                System.out.println("Enter the size:");
                int size = scanner.nextInt();
                System.out.println("Is it smart? (true/false)");
                boolean isSmart = scanner.nextBoolean();
                cart.addProduct(new TV(name, description, price, vat, size, isSmart));
            } else if (choice == 3) {
                System.out.println("Enter the color:");
                String color = scanner.nextLine();
                System.out.println("Is it wireless? (true/false)");
                boolean isWireless = scanner.nextBoolean();
                cart.addProduct(new Headphone(name, description, price, vat, color, isWireless));
            }
        }

        System.out.println("Do you have a loyalty card? (true/false)");
        boolean hasLoyaltyCard = scanner.nextBoolean();

        System.out.println("Cart:\n" + cart);
        System.out.println("Total: " + cart.getTotal(hasLoyaltyCard));

        scanner.close();
    }
}