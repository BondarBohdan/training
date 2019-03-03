package com.company.products.flowers.potFlowers;

import com.company.enums.Color;
import com.company.enums.Country;
import com.company.products.flowers.Flower;

import java.util.Objects;

public abstract class PotFlower extends Flower {
    private int lifetime;

    public PotFlower(double price, Country country, Color color, int lifetime) {
        super(price, country, color);
        this.lifetime = lifetime;
    }

    public int getLifetime() {
        return lifetime;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\t: price - " + getPrice() +
                ", lifetime - " + getLifetime() +
                " years, color - " + getColor() +
                ", country - " + getCountry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PotFlower that = (PotFlower) o;
        return lifetime == that.lifetime && getCountry() == that.getCountry() && getPrice() == that.getPrice() &&
                getColor() == that.getColor();
    }

    @Override
    public int hashCode() {

        return Objects.hash(lifetime);
    }
}
