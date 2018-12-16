public class Share extends Security {
    double dividentPercenage;

    Share(String symbol, double price, String ownerName, RiskLevel riskLevel, double dividentPercenage, Trend trend) {
        super(symbol, price, ownerName, riskLevel, trend);
        this.type = SecurityType.SHARE;
        this.dividentPercenage = dividentPercenage;
    }

    @Override
    public String toString() {
        return "Type - " + type +
                ", symbol - " + symbol +
                ", price - " + price +
                ", owner name - " + ownerName +
                ", risk level - " + riskLevel +
                ", dividents - " + dividentPercenage + "%," +
                " trend - " + trend;
    }
}
