public abstract class Security {
    protected String symbol;
    protected SecurityType type;
    protected double price;
    protected String ownerName;
    protected RiskLevel riskLevel;
    protected Trend trend;

    Security(String symbol, double price, String ownerName, RiskLevel riskLevel, Trend trend){
            this.symbol = symbol;
            this.price = price;
            this.ownerName = ownerName;
            this.riskLevel = riskLevel;
            this.trend = trend;
    }

    public enum SecurityType {
        SHARE, BOND;
    }

    public enum Trend {
        UP_TREND, DOWN_TREND, CONSOLIDATION;
    }

    public enum RiskLevel {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }



}
