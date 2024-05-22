package org.learning.oop.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        // Open Scanner
        Scanner scanner = new Scanner(System.in);

        // Generate empty cart
        int cartSize;
        System.out.print("Quanti prodotti vuoi aggiungere? ");
        cartSize = Integer.parseInt(scanner.nextLine());
        Product[] cartContents = new Product[cartSize];

        // Add products
        String productType;
        int i = 0;

        while (i < cartSize) {
            System.out.println("Che tipo di prodotto vuoi aggiungere?");
            System.out.println("Smartphone (s), TV (t), Headphones (h)");
            productType = scanner.nextLine();
            System.out.println("Inserisci i dettagli del prodotto.");

            String name, description;
            BigDecimal price, vat;
            System.out.print("Nome: ");
            name = scanner.nextLine();
            System.out.print("Descrizione: ");
            description = scanner.nextLine();
            System.out.print("Prezzo (€): ");
            price = new BigDecimal(scanner.nextLine());
            System.out.print("IVA (%): ");
            vat = new BigDecimal(scanner.nextLine());

            switch (productType) {
                case "s":
                    String imei;
                    int storage;
                    System.out.print("IMEI: ");
                    imei = scanner.nextLine();
                    System.out.print("Memoria (GB): ");
                    storage = Integer.parseInt(scanner.nextLine());
                    cartContents[i] = new Smartphone(name, description, price, vat, imei, storage);
                    i++;
                    break;
                case "t":
                    int size;
                    boolean isSmart;
                    System.out.print("Dimensioni (pollici): ");
                    size = Integer.parseInt(scanner.nextLine());
                    System.out.print("La TV è smart? (y)/(n): ");
                    isSmart = scanner.nextLine().equalsIgnoreCase("y");
                    cartContents[i] = new TV(name, description, price, vat, size, isSmart);
                    i++;
                    break;
                case "h":
                    String color;
                    boolean isWireless;
                    System.out.print("Colore: ");
                    color = scanner.nextLine();
                    System.out.print("Le cuffie sono wireless? (y)/(n): ");
                    isWireless = scanner.nextLine().equalsIgnoreCase("y");
                    cartContents[i] = new Headphone(name, description, price, vat, color, isWireless);
                    i++;
                    break;
                default:
                    System.out.println("Input non valido! Riprova.");
            }
        }

        // Total price
        BigDecimal totalPrice = BigDecimal.ZERO;
        System.out.print("Hai una carta fedeltà? (y)/(n) ");
        boolean hasCard = scanner.nextLine().equalsIgnoreCase("y");

        // Print cart
        System.out.println("****************");
        System.out.println("Ecco i dettagli inseriti:");
        for (Product product : cartContents) {
            BigDecimal currentPrice;
            if (hasCard) {
                currentPrice = product.getDiscountedPrice();
            } else {
                currentPrice = product.getFullPrice();
            }
            totalPrice = totalPrice.add(currentPrice);
            System.out.println(product.getFullName() + ", " + product.getDescription() + ", " + currentPrice + "€");
        }

        System.out.println("****************");
        System.out.println("Prezzo totale: " + totalPrice.setScale(2, RoundingMode.HALF_EVEN) + "€");

        // Close Scanner
        scanner.close();
    }
}