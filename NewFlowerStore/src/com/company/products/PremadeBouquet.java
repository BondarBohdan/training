package com.company.products;

import java.util.Objects;

public class PremadeBouquet extends Product {
    private String name;

    public PremadeBouquet(String name, double price) {
        super(price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() +
                "\t: price - " + getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremadeBouquet that = (PremadeBouquet) o;
        return Objects.equals(name, that.name) && getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
