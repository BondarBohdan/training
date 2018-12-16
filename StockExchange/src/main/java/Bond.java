public class Bond extends Security {
    int expiration;

    Bond(String symbol, double price, String ownerName, RiskLevel riskLevel, int expiration, Trend trend) {
        super(symbol, price, ownerName, riskLevel, trend);
        this.type = SecurityType.BOND;
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Type - " + type +
                ", symbol - " + symbol +
                ", price - " + price +
                ", owner name - " + ownerName +
                ", risk level - " + riskLevel +
                ", expiration in " + expiration + " month(s)," +
                " trend - " + trend;
    }
}
