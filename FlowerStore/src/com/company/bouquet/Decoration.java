package com.company.bouquet;

import com.company.products.Product;
import com.company.products.flowers.Flower;

import java.util.LinkedHashMap;
import java.util.Map;

public class Decoration extends Product implements IDecoration {
    private Map<Flower, Integer> flowers = new LinkedHashMap<>();

    public Decoration(double price) {
        super(price);
    }

    public Map<Flower, Integer> getFlowers() {
        return flowers;
    }

    @Override
    public String getDesc() {
        return "Bouquet decorations";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
