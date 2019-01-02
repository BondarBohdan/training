package com.company;

import flowers.Flower;

import java.util.List;

public class Discount {
    public static double calculateNewPrice (List<Product> products){
        int orderedProductSize = 0;
        double newPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            orderedProductSize += Order.access().getOrderQuantity().get(i);
            newPrice += (products.get(i).getPrice() * Order.access().getOrderQuantity().get(i));
        }
        /*for (Product product :products) {
            orderedProductSize += Order.access().getOrderQuantity().get(Order.access().getOrderList().indexOf(product));
            newPrice += (product.getPrice() * Order.access().getOrderQuantity().get(Order.access().getOrderList().indexOf(product)));
        }*/

        if (orderedProductSize > 5 && orderedProductSize <= 15){
            newPrice *= 0.9;
        } else if (orderedProductSize > 16) {
            newPrice *= 0.8;
        }

        return newPrice;
    }

    public  static double calculatePriceWithBouquet (List<Product> products) {
        int orderedProductSize = 1;
        double bouquet = 0;
        double newPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Flower) {
                bouquet += (products.get(i).getPrice() * Order.access().getOrderQuantity().get(i));
            } else {
                orderedProductSize += Order.access().getOrderQuantity().get(i);
                newPrice += (products.get(i).getPrice() * Order.access().getOrderQuantity().get(i));
            }
        }
        bouquet *= 0.7;

        if (orderedProductSize > 5 && orderedProductSize <= 15){
            newPrice *= 0.9;
        } else if (orderedProductSize > 16) {
            newPrice *= 0.8;
        }


        return newPrice + bouquet;
    }
}