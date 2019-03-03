package com.company.bouquet.wrappers;

import com.company.bouquet.BouquetDecorator;
import com.company.bouquet.IDecoration;

public class Cellophane extends BouquetDecorator {

    private final IDecoration bouquet;

    public Cellophane(IDecoration bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 7;
    }

    @Override
    public String getDesc() {
        return bouquet.getDesc() + ", cellophane";
    }
}
