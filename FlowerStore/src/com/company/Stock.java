package com.company;

import flowers.*;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Flower> flowersAvailable = new ArrayList<Flower>(addFlowers());
    private List<PalmTree> palmsTreesAvailable = new ArrayList<PalmTree>(addPalmTrees());
    private List<Bouquet> bouquetsAvailable = new ArrayList<Bouquet>(addBouquets());

    private static Stock ourInstance = new Stock();

    public static Stock access() {
        return ourInstance;
    }

    private Stock() {
    }

    public List<Flower> getFlowersAvailable() {
        return flowersAvailable;
    }

    public List<PalmTree> getPalmsTreesAvailable() {
        return palmsTreesAvailable;
    }

    public List<Bouquet> getBouquetsAvailable() {
        return bouquetsAvailable;
    }

    public List<Flower> addFlowers(){
        List<Flower> flowers = new ArrayList<Flower>();
        flowers.add(new Cactus("Cactus",5.5, Countries.MEXICO, 35, Colors.GREEN, 15));
        flowers.add(new Gladiolus("Gladiolus", 10, Countries.COLOMBIA, 40, Colors.PINK, 25));
        flowers.add(new Lily("Lily", 12, Countries.ETHIOPIA, 50, Colors.PURPLE, 40));
        flowers.add(new Orchid("Orchid",8, Countries.ISRAEL, 70, Colors.RED, 30));
        flowers.add(new Tulip("Tulip", 13.3, Countries.ITALY, 80, Colors.WHITE, 35));
        return flowers;
    }

    public List<PalmTree> addPalmTrees(){
        List<PalmTree> palmTrees = new ArrayList<PalmTree>();
        palmTrees.add(new PalmTree("Palm Tree", 45, Countries.KENYA, 10));
        return palmTrees;
    }

    public List<Bouquet> addBouquets(){
        List<Flower> bouq1 = new ArrayList<Flower>();
        bouq1.add(new Tulip("Tulip", 13.3, Countries.ITALY, 35, Colors.WHITE, 3));
        bouq1.add(new Lily("Lily", 12, Countries.ETHIOPIA, 35, Colors.PURPLE, 4));
        List<Bouquet> bouquets = new ArrayList<Bouquet>();
        bouquets.add(new Bouquet("bouq1", 50, Countries.MIXED, 3, bouq1));
        return bouquets;
    }

    public void viewFlowersAvailable(){
        for (int i = 0; i < flowersAvailable.size(); i++) {
            System.out.println((i+1) + " - " + flowersAvailable.get(i));
        }
    }

    public void viewPalmTreesAvailable(){
        for (int i = 0; i < palmsTreesAvailable.size(); i++) {
            System.out.println((i+1) + " - " + palmsTreesAvailable.get(i));
        }
    }

    public void viewBouquetsAvailable(){
        for (int i = 0; i < bouquetsAvailable.size(); i++) {
            System.out.println((i+1) + " - " + bouquetsAvailable.get(i));
        }
    }

    public void changeAvailableQuantity(){
        int newQuantity;
        int indexInOrderList;

        for (Product product : Order.access().getOrderList()) {
            indexInOrderList = Order.access().getOrderQuantity().get(Order.access().getOrderList().indexOf(product));

            if (flowersAvailable.contains(product)) {
                newQuantity = flowersAvailable.get(flowersAvailable.indexOf(product)).getQuantity() -
                        indexInOrderList;
                if (newQuantity <= 0) {
                    flowersAvailable.remove(product);
                } else {
                    flowersAvailable.get(flowersAvailable.indexOf(product)).setQuantity(newQuantity);
                }
            } else if (palmsTreesAvailable.contains(product)) {
                newQuantity = palmsTreesAvailable.get(palmsTreesAvailable.indexOf(product)).getQuantity() -
                        indexInOrderList;
                if (newQuantity <= 0) {
                    palmsTreesAvailable.remove(product);
                } else {
                    palmsTreesAvailable.get(palmsTreesAvailable.indexOf(product)).setQuantity(newQuantity);
                }
            } else if (bouquetsAvailable.contains(product)) {
                newQuantity = bouquetsAvailable.get(bouquetsAvailable.indexOf(product)).getQuantity() -
                        indexInOrderList;
                if (newQuantity <= 0) {
                    bouquetsAvailable.remove(product);
                } else {
                    bouquetsAvailable.get(bouquetsAvailable.indexOf(product)).setQuantity(newQuantity);
                }
            }
        }

    }
}
