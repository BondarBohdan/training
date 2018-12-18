public abstract class Plant {
    protected String name;
    protected GardenningSeason gardenningSeason;
    protected Lifetime lifetime;

    public Plant(GardenningSeason gardenningSeason, Lifetime lifetime) {
        this.gardenningSeason = gardenningSeason;
        this.lifetime = lifetime;
    }

    public GardenningSeason getGardenningSeason() {
        return gardenningSeason;
    }

    public Lifetime getLifetime() {
        return lifetime;
    }

    @Override
    public String toString() {
        return "Name - " + name +
                ", gardenning season - " + gardenningSeason +
                ", lifetime - " + lifetime;}
}

    enum GardenningSeason {
    WINTER, SPRING, SUMMER, FALL;
}

    enum Lifetime {
    ONE_YEAR, TWO_YEARS, OVER_5_YEARS, OVER_20_YEARS;
}
