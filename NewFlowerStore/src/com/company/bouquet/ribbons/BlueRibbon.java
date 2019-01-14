package com.company.bouquet.ribbons;

import com.company.bouquet.BouquetDecorator;
import com.company.bouquet.IDecoration;

public class BlueRibbon extends BouquetDecorator {

    private final IDecoration bouquet;

    public BlueRibbon(IDecoration bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 5;
    }

    @Override
    public String getDesc() {
        return bouquet.getDesc() + ", blue ribbon";
    }
}
