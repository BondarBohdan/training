package com.company;

import com.company.bouquet.*;
import com.company.products.Product;
import com.company.products.flowers.bouquetFlowers.BouquetFlower;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private Map<Object, Integer> orderList = new LinkedHashMap<>();

    private static Order instance = new Order();

    public static Order access() {
        return instance;
    }

    private Order() {
    }

    public Map<Object, Integer> getOrderList() {
        return orderList;
    }


    public void addToOrderList(Object product, int quantity) {
        orderList.put(product, quantity);
    }

    public Bouquet createBouquet(){
        Bouquet bouquet = new Bouquet(0);

        Iterator<Map.Entry<Object, Integer>> iterator = orderList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Integer> pair = iterator.next();

            if (pair.getKey() instanceof BouquetFlower){
                bouquet.getFlowers().put((BouquetFlower) pair.getKey(), pair.getValue());
                iterator.remove();
            }
        }

        orderList.put(bouquet, 1);

        return bouquet;
    }

    public double calculatePrice(){
        double sum = 0.0;
        for (Map.Entry<Object, Integer> entry : orderList.entrySet()) {
            if (entry.getKey() instanceof IDecoration){
                sum += ((IDecoration) entry.getKey()).getPrice();
            } else if (entry.getKey() instanceof Product) {
                sum += ((Product) entry.getKey()).getPrice();
            }
        }
        return sum;
    }

    public void viewOrderInfo() {
        System.out.println("Your order is ");
        for (Map.Entry<Object, Integer> entry : orderList.entrySet()) {
            if (entry.getKey() instanceof IDecoration){
                System.out.println(((IDecoration) entry.getKey()).getDesc());
            } else {
                System.out.println(entry.getKey() + " " + "(" + entry.getValue() + ")");
            }
        }

    }

    public void clearOrderList(){
        orderList.clear();
    }
}
