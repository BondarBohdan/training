package com.company.bouquet.wrappers;

import com.company.bouquet.BouquetDecorator;
import com.company.bouquet.IDecoration;

public class Paper extends BouquetDecorator {

    private final IDecoration bouquet;

    public Paper(IDecoration bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 10;
    }

    @Override
    public String getDesc() {
        return bouquet.getDesc() + ", paper";
    }
}
