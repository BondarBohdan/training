package com.company.products;

public abstract class Product {
    private double price;

    public Product(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
