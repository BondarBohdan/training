import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StockExchange {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Security> securities = new ArrayList<Security>(createSecurities());

    private StockExchange() {}

    private static StockExchange stockExchange = new StockExchange();

    public static StockExchange access() {
        return stockExchange;
    }

    public static ArrayList<Security> createSecurities() {
        ArrayList<Security> securities = new ArrayList<Security>();
        securities.add(new Bond("GOVT", 24.54, "John B.", Security.RiskLevel.MEDIUM,
                3, Security.Trend.DOWN_TREND));
        securities.add(new Bond("SCHO", 49.65, "Lenny D.", Security.RiskLevel.HIGH,
                8, Security.Trend.UP_TREND));
        securities.add(new Bond("SPTL", 34.24, "Bob A.", Security.RiskLevel.LOW,
                24, Security.Trend.CONSOLIDATION));
        securities.add(new Bond("TLH", 130.90, "Denis C.", Security.RiskLevel.VERY_HIGH,
                120, Security.Trend.DOWN_TREND));

        securities.add(new Share("UXIN", 7.79, "Dana L.", Security.RiskLevel.LOW,
                1.1, Security.Trend.CONSOLIDATION));
        securities.add(new Share("WFC", 48.13, "Sam K.", Security.RiskLevel.VERY_HIGH,
                2.1, Security.Trend.UP_TREND));
        securities.add(new Share("URI", 111.13, "Andrew C.", Security.RiskLevel.MEDIUM,
                3, Security.Trend.DOWN_TREND));
        securities.add(new Share("TLRY", 89.25, "Mark T.", Security.RiskLevel.HIGH,
                0.8, Security.Trend.UP_TREND));
        return securities;
    }

    public void sortByRiskLevel() {
        Collections.sort(securities, new Comparator<Security>() {
            @Override
            public int compare(Security o1, Security o2) {
                return o1.riskLevel.compareTo(o2.riskLevel);
            }
        });

        System.out.println("Sorted by risk level");
    }

    public void sortByTrend() {
        Collections.sort(securities, new Comparator<Security>() {
            @Override
            public int compare(Security o1, Security o2) {
                return o1.trend.compareTo(o2.trend);
            }
        });

        System.out.println("Sorted by trend");
    }

    public void sortByPrice() {
        Collections.sort(securities, new Comparator<Security>() {
            public int compare(Security o1, Security o2) {
                if (o1.price > o2.price)
                    return 1;
                if (o1.price < o2.price)
                    return -1;
                return 0;
            }
        });

        System.out.println("Sorted by price");
    }

    public void printSecurities () {
        for (Security security : securities) {
            System.out.println(security);
        }
        System.out.println();
    }

    public void searchEngine() {
        System.out.println("To search securities by price enter 1.\n" +
                "To search securities by risk level enter 2.\n" +
                "To search securities by trend enter 3.");

        try {
            int enteredValue = Integer.parseInt(reader.readLine());
            if (enteredValue == 1){
                System.out.println("Specify beginning of the price range");
                System.out.println("from: ");
                double from = Double.parseDouble(reader.readLine());
                System.out.println("to: ");
                double to = Double.parseDouble(reader.readLine());
                StockExchange.access().searchByPrice(from, to);
            } else if (enteredValue == 2) {
                System.out.println("To view securities with Low risk level enter 1\n" +
                        "To view securities with Medium risk level enter 2\n" +
                        "To view securities with High risk level enter 3\n" +
                        "To view securities with Very High risk level enter 4");
                switch (Integer.parseInt(reader.readLine())){
                    case 1:
                        StockExchange.access().searchByRiskLevel(Security.RiskLevel.LOW);
                        break;
                    case 2:
                        StockExchange.access().searchByRiskLevel(Security.RiskLevel.MEDIUM);
                        break;
                    case 3:
                        StockExchange.access().searchByRiskLevel(Security.RiskLevel.HIGH);
                        break;
                    case 4:
                        StockExchange.access().searchByRiskLevel(Security.RiskLevel.VERY_HIGH);
                        break;
                    default:
                        System.out.println("Entered wrong value. System shut down.");
                        System.exit(1);
                        break;
                }
            } else if (enteredValue == 3){
                System.out.println("To view Up trend securities enter 1\n" +
                        "To view Down trend securities enter 2\n" +
                        "To view securities in consolidation enter 3");
                switch (Integer.parseInt(reader.readLine())){
                    case 1:
                        StockExchange.access().searchByTrend(Security.Trend.UP_TREND);
                        break;
                    case 2:
                        StockExchange.access().searchByTrend(Security.Trend.DOWN_TREND);
                        break;
                    case 3:
                        StockExchange.access().searchByTrend(Security.Trend.CONSOLIDATION);
                        break;
                    default:
                        System.out.println("Entered wrong value. System shut down.");
                        System.exit(1);
                        break;
                }
            } else {
                System.out.println("Entered wrong value. System shut down.");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("An error occurred, restart the application.");
        }
    }

    public void searchByPrice (double from, double to){
        ArrayList<Security> foundSecurities = new ArrayList<Security>();
        for (Security security :securities) {
            if (security.price >= from && security.price <= to) {
                foundSecurities.add(security);
            }
        }
        if (foundSecurities.isEmpty()) {
            System.out.println("There is no securities with price in range from " + from + " to " + to);
        } else {
           Collections.sort(foundSecurities, new Comparator<Security>() {
                public int compare(Security o1, Security o2) {
                    if (o1.price > o2.price)
                        return 1;
                    if (o1.price < o2.price)
                        return -1;
                    return 0;
                }
            });
            for (Security security :foundSecurities) {
                System.out.println(security);
            }
        }
    }

    public void searchByRiskLevel (Security.RiskLevel riskLevel){
        ArrayList<Security> foundSecurities = new ArrayList<Security>();
        for (Security security :securities) {
            if (security.riskLevel.equals(riskLevel)) {
                foundSecurities.add(security);
            }
        }
        if (foundSecurities.isEmpty()) {
            System.out.println("There is no securities with " + riskLevel + " risk level.");
        } else {
            for (Security security :foundSecurities) {
                System.out.println(security);
            }
        }
    }

    public void searchByTrend (Security.Trend trend){
        ArrayList<Security> foundSecurities = new ArrayList<Security>();
        for (Security security :securities) {
            if (security.trend.equals(trend)) {
                foundSecurities.add(security);
            }
        }
        if (foundSecurities.isEmpty()) {
            System.out.println("There is no securities with " + trend + " trend.");
        } else {
            for (Security security :foundSecurities) {
                System.out.println(security);
            }
        }
    }
}
