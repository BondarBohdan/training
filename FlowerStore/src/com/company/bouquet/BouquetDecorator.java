package com.company.bouquet;

public abstract class BouquetDecorator implements IDecoration {
    @Override
    public String getDesc() {
        return "decorations";
    }
}
