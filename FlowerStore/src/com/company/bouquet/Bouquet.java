package com.company.bouquet;

import com.company.products.Product;
import com.company.products.flowers.Flower;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bouquet extends Product {
    private Map<Flower, Integer> flowers = new LinkedHashMap<>();

    public Bouquet(double price) {
        super(price);
    }

    public Map<Flower, Integer> getFlowers() {
        return flowers;
    }

    private String viewFlowers(){
        String flower = "";
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
           flower += (entry.getValue() + " " + entry.getKey().getClass().getSimpleName() + "(s) ");
        }
        return flower;
    }

    @Override
    public String toString() {
        return "Bouquet of:" + viewFlowers();
    }
}
