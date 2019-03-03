package com.company;

import com.company.enums.*;
import com.company.products.*;
import com.company.products.flowers.bouquetFlowers.*;
import com.company.products.flowers.potFlowers.*;
import com.company.products.vessels.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Stock {
    private Map<Product, Integer> availableBouquetFlowers = new LinkedHashMap<>(addBouquetFlowers());
    private Map<Product, Integer> availablePotFlowers = new LinkedHashMap<>(addPotFlowers());
    private Map<Product, Integer> availablePots = new LinkedHashMap<>(addPots());
    private Map<Product, Integer> availableVases = new LinkedHashMap<>(addVases());
    private Map<Product, Integer> availableCactuses = new LinkedHashMap<>(addCactuses());
    private Map<Product, Integer> availablePalmTrees = new LinkedHashMap<>(addPalmTrees());
    private Map<Product, Integer> availablePremadeBouquets = new LinkedHashMap<>(addPremadeBouquets());

    private static Stock instance = new Stock();

    public static Stock access() {
        return instance;
    }

    private Stock() {

    }

    public Map<Product, Integer> getAvailableBouquetFlowers() {
        return availableBouquetFlowers;
    }

    public Map<Product, Integer> getAvailablePotFlowers() {
        return availablePotFlowers;
    }

    public Map<Product, Integer> getAvailablePots() {
        return availablePots;
    }

    public Map<Product, Integer> getAvailableVases() {
        return availableVases;
    }

    public Map<Product, Integer> getAvailableCactuses() {
        return availableCactuses;
    }

    public Map<Product, Integer> getAvailablePalmTrees() {
        return availablePalmTrees;
    }

    public Map<Product, Integer> getAvailablePremadeBouquets() {
        return availablePremadeBouquets;
    }

    private Map<BouquetFlower, Integer> addBouquetFlowers(){
        Map<BouquetFlower, Integer> map = new HashMap<>();

        map.put(new Rose(14, Country.NATIVE, Color.WHITE, 60), 30);
        map.put(new Rose(20, Country.NATIVE, Color.RED, 90), 30);
        map.put(new Hyacinth(8, Country.COLOMBIA, Color.PURPLE, 60), 30);

        return map;
    }

    private Map<PotFlower, Integer> addPotFlowers(){
        Map<PotFlower, Integer> map = new HashMap<>();

        map.put(new Orchid(50, Country.ETHIOPIA, Color.WHITE, 8), 10);
        map.put(new Orchid(50, Country.ETHIOPIA, Color.PINK, 8), 10);

        return map;
    }

    private Map<Pot, Integer> addPots(){
        Map<Pot, Integer> map = new HashMap<>();

        map.put(new Pot(20, Color.WHITE, Size.BIG), 5);
        map.put(new Pot(20, Color.WHITE, Size.SMALL), 5);

        return map;
    }

    private Map<Vase, Integer> addVases(){
        Map<Vase, Integer> map = new HashMap<>();

        map.put(new Vase(30, Color.RED, Size.MEDIUM), 5);
        map.put(new Vase(30, Color.PINK, Size.MEDIUM), 5);

        return map;
    }

    private Map<Cactus, Integer> addCactuses(){
        Map<Cactus, Integer> map = new HashMap<>();

        map.put(new Cactus(15, Size.SMALL), 5);

        return map;
    }

    private Map<PalmTree, Integer> addPalmTrees(){
        Map<PalmTree, Integer> map = new HashMap<>();

        map.put(new PalmTree(45), 5);

        return map;
    }

    private Map<PremadeBouquet, Integer> addPremadeBouquets(){
        Map<PremadeBouquet, Integer> map = new HashMap<>();

        map.put(new PremadeBouquet("Vesna", 200), 1);
        map.put(new PremadeBouquet("Tropikana", 350), 1);
        map.put(new PremadeBouquet("Gracia", 150), 1);

        return map;
    }

    public void viewProductMap(Map<Product, Integer> map){
        int sequenceNum = 1;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            System.out.println(sequenceNum + " - " + entry.getKey() + ". " + entry.getValue() + " pcs");
            sequenceNum++;
        }
    }
}