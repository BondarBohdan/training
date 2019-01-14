package com.company.bouquet.ribbons;

import com.company.bouquet.BouquetDecorator;
import com.company.bouquet.IDecoration;

public class WhiteRibbon extends BouquetDecorator {

    private final IDecoration bouquet;

    public WhiteRibbon(IDecoration bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 5;
    }

    @Override
    public String getDesc() {
        return bouquet.getDesc() + ", white ribbon";
    }
}
