package com.company.products.flowers.bouquetFlowers;

import com.company.enums.Color;
import com.company.enums.Country;
import com.company.products.flowers.Flower;

import java.util.Objects;

public abstract class BouquetFlower extends Flower {
    private int stemLength;

    public BouquetFlower(double price, Country country, Color color, int stemLength) {
        super(price, country, color);
        this.stemLength = stemLength;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\t: price - " + getPrice() +
                ", stem length - " + getStemLength() +
                ", color - " + getColor() +
                ", country - " + getCountry();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BouquetFlower that = (BouquetFlower) o;
        return stemLength == that.stemLength && getCountry() == that.getCountry() && getPrice() == that.getPrice() &&
                getColor() == that.getColor();
    }

    @Override
    public int hashCode() {

        return Objects.hash(stemLength);
    }
}
