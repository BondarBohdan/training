package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Menu ourInstance = new Menu();

    public static Menu access() {
        return ourInstance;
    }

    private Menu() {
    }

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("\nWelcome to Don Pedro's Flower Store.\n" +
                "Choose what would you like to view:\n" +
                "1 - available flowers;\n" +
                "2 - available trees;\n" +
                "3 - available bouquets;\n" +
                "4 - to buy ordered flowers as a bouquet.\n" +
                "Press \"Enter\" button exit.");

        mainMenuChoice();
    }

    private void mainMenuChoice() {
        String line = "start";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    switch (Integer.parseInt(line)) {
                        case 1:
                            Stock.access().viewFlowersAvailable();
                            flowerMenuChoice();
                            break;
                        case 2:
                            Stock.access().viewPalmTreesAvailable();
                            palmTreesMenuChoice();
                            break;
                        case 3:
                            Stock.access().viewBouquetsAvailable();
                            bouquetMenuChoice();
                            break;
                        case 4:
                            Order.access().setFlowersAsBouquet(true);
                            confirmedOrderAction();
                            break;
                        default:
                            System.out.println("Entered wrong value, try again.");
                            continue;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void flowerMenuChoice(){
        System.out.println("Enter flower number you want to buy:\n" +
                "\nenter 0 to go back or press \"Enter\" button to exit.");
        String line = "start";
        String howManyMessage = "how many pcs you want to buy?";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    int choice = Integer.parseInt(line);
                    if (choice > 0 && choice <= Stock.access().getFlowersAvailable().size()) {
                        System.out.println(howManyMessage);
                        int amount = Integer.parseInt(reader.readLine());
                        if (amount <= Stock.access().getFlowersAvailable().get(choice - 1).getQuantity()) {
                            Order.access().addToOrderList(Stock.access().getFlowersAvailable().get(choice - 1), amount);
                            returnExitOrContinue();
                        } else {
                            System.out.println("Sorry, " + amount + " pcs unavailable now.");
                            run();
                        }
                    } else if (Integer.parseInt(line) == 0) {
                        run();
                    } else {
                        flowerMenuChoice();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void palmTreesMenuChoice(){
        System.out.println("Enter tree number you want to buy:\n" +
                "\nenter 0 to go back or press \"Enter\" button to exit.");
        String line = "start";
        String howManyMessage = "how many pcs you want to buy?";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    int choice = Integer.parseInt(line);
                    if (choice > 0 && choice <= Stock.access().getPalmsTreesAvailable().size()) {
                        System.out.println(howManyMessage);
                        int amount = Integer.parseInt(reader.readLine());
                        if (amount <= Stock.access().getPalmsTreesAvailable().get(choice - 1).getQuantity()) {
                            Order.access().addToOrderList(Stock.access().getPalmsTreesAvailable().get(choice - 1), amount);
                            returnExitOrContinue();
                        } else {
                            System.out.println("Sorry, " + amount + " pcs unavailable now.");
                            run();
                        }
                    } else if (Integer.parseInt(line) == 0) {
                        run();
                    } else {
                        palmTreesMenuChoice();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void bouquetMenuChoice(){
        System.out.println("Enter bouquet number you want to buy:\n" +
                "\nenter 0 to go back or press \"Enter\" button to exit.");
        String line = "start";
        String howManyMessage = "how many pcs you want to buy?";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    int choice = Integer.parseInt(line);
                    if (choice > 0 && choice <= Stock.access().getBouquetsAvailable().size()) {
                        System.out.println(howManyMessage);
                        int amount = Integer.parseInt(reader.readLine());
                        if (amount <= Stock.access().getBouquetsAvailable().get(choice - 1).getQuantity()) {
                            Order.access().addToOrderList(Stock.access().getBouquetsAvailable().get(choice - 1), amount);
                            returnExitOrContinue();
                        } else {
                            System.out.println("Sorry, " + amount + " pcs unavailable now.");
                            run();
                        }
                    } else if (Integer.parseInt(line) == 0) {
                        run();
                    } else {
                        flowerMenuChoice();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void returnExitOrContinue() throws IOException {
        System.out.println("Enter 0 to go to main menu, enter 1 to order or press \"Enter\" button to exit.");
        String line = reader.readLine();
        int choice = Integer.parseInt(line);
        if (choice == 0) {
            run();
        } else if (choice == 1) {
            confirmedOrderAction();
        } else if (line.isEmpty()) {
            System.exit(0);
        } else {
            returnExitOrContinue();
        }
    }

    public void confirmedOrderAction(){
        Order.access().viewOrderInfo();
        System.out.println("Thank you for your order.");
        Stock.access().changeAvailableQuantity();
        Order.access().clearOrderList();
        run();
    }

}
