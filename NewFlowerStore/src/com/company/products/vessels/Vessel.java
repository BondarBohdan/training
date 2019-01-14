package com.company.products.vessels;

import com.company.enums.Color;
import com.company.enums.Size;
import com.company.products.Product;

import java.util.Objects;

public abstract class Vessel extends Product{

    private Color color;
    private Size size;

    public Vessel(double price, Color color, Size size) {
        super(price);
        this.color = color;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\t: price - " + getPrice() +
                ", size - " + getSize() +
                ", color - " + getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vessel vessel = (Vessel) o;
        return color == vessel.color &&
                size == vessel.size && getPrice() == vessel.getPrice();
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, size);
    }
}
