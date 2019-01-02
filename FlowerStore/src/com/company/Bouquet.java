package com.company;

import flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet extends Product {
    private List<Flower> flowers = new ArrayList<>();

    public Bouquet(String name, double price, Countries country, int quantity, List<Flower> flowers) {
        super(name, price, country, quantity);
        this.flowers = flowers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public String toString() {
        String flowers = "";
        for (Flower flower :getFlowers()) {
            flowers += flower.getName() + " (" + flower.getQuantity() + ") ";
        }

        return "Bouquet: " +
                "name - " + getName() +
                ", flowers - " + flowers +
                ", available - " + getQuantity() +
                ", price - " + getPrice();
    }
}
