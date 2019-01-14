package com.company.products;

public class PalmTree extends Product {
    public PalmTree(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "\t: price - " + getPrice();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalmTree palmTree = (PalmTree) o;
        return getPrice() == palmTree.getPrice();
    }
}