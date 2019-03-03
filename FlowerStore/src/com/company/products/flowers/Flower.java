package com.company.products.flowers;

import com.company.enums.Color;
import com.company.enums.Country;
import com.company.products.Product;

public abstract class Flower extends Product {
    private Country country;
    private Color color;

    public Flower(double price, Country country, Color color) {
        super(price);
        this.country = country;
        this.color = color;
    }

    public Country getCountry() {
        return country;
    }

    public Color getColor() {
        return color;
    }

}