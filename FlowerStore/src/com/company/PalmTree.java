package com.company;

public class PalmTree extends Product {
    public PalmTree(String name, double price, Countries country, int quantity) {
        super(name, price, country, quantity);
    }

    @Override
    public String toString() {
        return getName() +
                ": price - " + getPrice() +
                ", country  - " + getCountry() +
                ", quantity available - " + getQuantity();
    }
}
