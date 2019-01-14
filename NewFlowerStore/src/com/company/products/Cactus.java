package com.company.products;

import com.company.enums.Size;

import java.util.Objects;

public class Cactus extends Product {
    private Size size;

    public Cactus(double price, Size size) {
        super(price);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\t: price - " + getPrice() +
                ", size - " + getSize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cactus cactus = (Cactus) o;
        return size == cactus.size && getPrice() == cactus.getPrice();
    }

    @Override
    public int hashCode() {

        return Objects.hash(size);
    }
}
