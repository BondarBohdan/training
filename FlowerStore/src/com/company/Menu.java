package com.company;

import com.company.bouquet.*;
import com.company.bouquet.ribbons.*;
import com.company.bouquet.wrappers.*;
import com.company.payment.PaymentMethodFactory;
import com.company.products.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Menu {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Menu instance = new Menu();

    public static Menu access() {
        return instance;
    }

    private Menu() {
    }

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("\nWelcome to Don Pedro's Flower Store.\n" +
                "Choose what would you like to buy:\n" +
                "1 - bouquet flowers;\n" +
                "2 - pot flowers;\n" +
                "3 - pots;\n" +
                "4 - vases;\n" +
                "5 - trees;\n" +
                "6 - cactuses;\n" +
                "7 - premade bouquets;\n" +
                "8 - to buy ordered flowers as bouquet;\n" +
                "9 - go to cart;\n" +
                "Press \"Enter\" button exit.");

        mainMenuChoice();
    }

    private void mainMenuChoice() {
        String line;
        try {
            if ((line = reader.readLine()).isEmpty()) {
                System.exit(0);
            } else {
                switch (Integer.parseInt(line)) {
                    case 1:
                        Stock.access().viewProductMap(Stock.access().getAvailableBouquetFlowers());
                        menuChoice(Stock.access().getAvailableBouquetFlowers());
                        break;
                    case 2:
                        Stock.access().viewProductMap(Stock.access().getAvailablePotFlowers());
                        menuChoice(Stock.access().getAvailablePotFlowers());
                        break;
                    case 3:
                        Stock.access().viewProductMap(Stock.access().getAvailablePots());
                        menuChoice(Stock.access().getAvailablePots());
                        break;
                    case 4:
                        Stock.access().viewProductMap(Stock.access().getAvailableVases());
                        menuChoice(Stock.access().getAvailableVases());
                        break;
                    case 5:
                        Stock.access().viewProductMap(Stock.access().getAvailablePalmTrees());
                        menuChoice(Stock.access().getAvailablePalmTrees());
                        break;
                    case 6:
                        Stock.access().viewProductMap(Stock.access().getAvailableCactuses());
                        menuChoice(Stock.access().getAvailableCactuses());
                        break;
                    case 7:
                        Stock.access().viewProductMap(Stock.access().getAvailablePremadeBouquets());
                        menuChoice(Stock.access().getAvailablePremadeBouquets());
                        break;
                    case 8:
                        Order.access().createBouquet();
                        whetherAddBouquetDecoration();
                        confirmedOrderAction();
                        break;
                    case 9:
                        confirmedOrderAction();
                        break;
                    default:
                        System.out.println("Entered wrong value, try again.");
                        mainMenuChoice();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void whetherAddBouquetDecoration() throws IOException {
        System.out.println("\nAdd any decorations?\n" +
                "1 - Y\n" +
                "2 - N");
        String line;
        if ((line = reader.readLine()).isEmpty()) {
            System.exit(0);
        } else {
            switch (Integer.parseInt(line)) {
                case 1:
                    Order.access().addToOrderList(decorationsMenu(), 1);
                    break;
                case 2:
                    mainMenu();
                    break;
                default:
                    System.out.println("Entered wrong value.");
                    mainMenu();
            }
        }
    }

    public void menuChoice(Map<Product, Integer> map) {
        System.out.println("Enter item number you want to buy:\n" +
                "\nEnter 0 to back to main menu or press \"Enter\" button to exit.");
        String line;
        String howManyMessage = "How many pcs you want to buy?";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    int choice = Integer.parseInt(line);
                    if (choice > 0 && choice <= map.size()) {
                        System.out.println(howManyMessage);
                        Integer amount = Integer.parseInt(reader.readLine());
                        if (amount <= ((Integer) map.values().toArray()[choice - 1]).intValue()) {
                            Order.access().addToOrderList((Product) map.keySet().toArray()[choice - 1], amount);
                            returnOrExit();
                        } else {
                            System.out.println("Sorry, " + amount + " pcs unavailable now.");
                            run();
                        }
                    } else if (Integer.parseInt(line) == 0) {
                        run();
                    } else {
                        System.out.println("Incorrect choice. Try again.");
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void decorationsMenuInfo(){
        System.out.println("Choose decoration to add.\n" +
                "1 - Blue ribbon;\n" +
                "2 - red ribbon;\n" +
                "3 - white ribbon;\n" +
                "4 - cellophane;\n" +
                "5 - paper;\n" +
                "0 - finish");
    }

    public IDecoration decorationsMenu() throws IOException {
        decorationsMenuInfo();
        IDecoration iDecoration = new Decoration(0);
        String line;

        while (!(line = reader.readLine()).equals("0")) {
            switch (Integer.parseInt(line)) {
                case 1:
                    iDecoration = new BlueRibbon(iDecoration);
                    break;
                case 2:
                    iDecoration = new RedRibbon(iDecoration);
                    break;
                case 3:
                    iDecoration = new WhiteRibbon(iDecoration);
                    break;
                case 4:
                    iDecoration = new Cellophane(iDecoration);
                    break;
                case 5:
                    iDecoration = new Paper(iDecoration);
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Entered wrong value, try again.");
                    decorationsMenu();
            }
        }

        return iDecoration;
    }

    public void choosePaymentMethod() throws IOException {
        System.out.println("\nChoose payment method\n" +
                "1 - Cash\n" +
                "2 - Card");
        String line;
        if ((line = reader.readLine()).isEmpty()) {
            System.exit(0);
        } else {
            switch (Integer.parseInt(line)) {
                case 1:
                    PaymentMethodFactory.getPaymentMethod(1).pay(Order.access().calculatePrice());
                    break;
                case 2:
                    PaymentMethodFactory.getPaymentMethod(2, readCardData()).pay(Order.access().calculatePrice());
                    break;
                default:
                    System.out.println("Entered wrong value.");
                    mainMenu();
            }
        }
    }

    public String[] readCardData() throws IOException {
        String[] data = new String[3];
        System.out.println("Enter card number");
        data[0] = reader.readLine();
        System.out.println("Enter card expiration date");
        data[1] = reader.readLine();
        System.out.println("Enter cvv");
        data[2] = reader.readLine();

        return data;
    }

    public void returnOrExit() throws IOException {
        System.out.println("Enter 0 to back to main menu or press \"Enter\" button to exit.");
        String line = reader.readLine();
        int choice = Integer.parseInt(line);
        if (choice == 0) {
            run();
        } else if (line.isEmpty()) {
            System.exit(0);
        } else {
            returnOrExit();
        }
    }

    public void confirmedOrderAction() throws IOException {
        Order.access().viewOrderInfo();
        choosePaymentMethod();
        Order.access().clearOrderList();
        run();
    }

}
