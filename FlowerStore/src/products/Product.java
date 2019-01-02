package products;

public abstract class Product {
    private String name;
    private double price;
    private Countries country;
    private int quantity;

    public Product(String name, double price, Countries country, int quantity){
        this.name = name;
        this.price = price;
        this.country = country;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Countries getCountry() {
        return country;
    }

    public int getQuantity() {
        return quantity;
    }
}
