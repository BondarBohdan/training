package com.company;

import flowers.*;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Product> flowersAvailable = new ArrayList<Product>(addFlowers());
    private List<Product> palmsTreesAvailable = new ArrayList<Product>(addPalmTrees());
    private List<Product> bouquetsAvailable = new ArrayList<Product>(addBouquets());

    private static Stock ourInstance = new Stock();

    public static Stock access() {
        return ourInstance;
    }

    private Stock() {

    }

    public List<Product> getFlowersAvailable() {
        return flowersAvailable;
    }

    public List<Product> getPalmsTreesAvailable() {
        return palmsTreesAvailable;
    }

    public List<Product> getBouquetsAvailable() {
        return bouquetsAvailable;
    }

    public List<Flower> addFlowers() {
        List<Flower> flowers = new ArrayList<Flower>();
        flowers.add(new Cactus("Cactus", 5.5, Countries.MEXICO, 35, Colors.GREEN, 15));
        flowers.add(new Gladiolus("Gladiolus", 10, Countries.COLOMBIA, 40, Colors.PINK, 25));
        flowers.add(new Lily("Lily", 12, Countries.ETHIOPIA, 50, Colors.PURPLE, 40));
        flowers.add(new Orchid("Orchid", 8, Countries.ISRAEL, 70, Colors.RED, 30));
        flowers.add(new Tulip("Tulip", 13.3, Countries.ITALY, 80, Colors.WHITE, 35));
        return flowers;
    }

    public List<PalmTree> addPalmTrees() {
        List<PalmTree> palmTrees = new ArrayList<PalmTree>();
        palmTrees.add(new PalmTree("Palm Tree", 45, Countries.KENYA, 10));
        return palmTrees;
    }

    public List<Bouquet> addBouquets() {
        List<Flower> bouq1 = new ArrayList<Flower>();
        bouq1.add(new Tulip("Tulip", 13.3, Countries.ITALY, 35, Colors.WHITE, 3));
        bouq1.add(new Lily("Lily", 12, Countries.ETHIOPIA, 35, Colors.PURPLE, 4));
        List<Bouquet> bouquets = new ArrayList<Bouquet>();
        bouquets.add(new Bouquet("bouq1", 50, Countries.MIXED, 3, bouq1));
        return bouquets;
    }

    public void viewFlowersAvailable() {
        for (int i = 0; i < flowersAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + flowersAvailable.get(i));
        }
    }

    public void viewPalmTreesAvailable() {
        for (int i = 0; i < palmsTreesAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + palmsTreesAvailable.get(i));
        }
    }

    public void viewBouquetsAvailable() {
        for (int i = 0; i < bouquetsAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + bouquetsAvailable.get(i));
        }
    }

    public void changeAvailableQuantity() {
        int indexInOrderList;

        for (Product product : Order.access().getOrderList()) {
            indexInOrderList = Order.access().getOrderQuantity().get(Order.access().getOrderList().indexOf(product));

            if (flowersAvailable.contains(product)) {
                calculateNewQuantity(flowersAvailable, product, indexInOrderList);
            } else if (palmsTreesAvailable.contains(product)) {
                calculateNewQuantity(palmsTreesAvailable, product, indexInOrderList);
            } else if (bouquetsAvailable.contains(product)) {
                calculateNewQuantity(bouquetsAvailable, product, indexInOrderList);
            }
        }

    }

    public void calculateNewQuantity(List<Product> list, Product product, int indexInOrderList) {
        int newQuantity = list.get(list.indexOf(product)).getQuantity() - indexInOrderList;

        if (newQuantity <= 0) {
            list.remove(product);
        } else {
            list.get(list.indexOf(product)).setQuantity(newQuantity);
        }
    }
}
