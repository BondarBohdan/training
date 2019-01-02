package flowers;

import com.company.Colors;
import com.company.Countries;
import com.company.Product;

public abstract class Flower extends Product {
    private int height;
    private Colors color;

    public Flower(String name, double price, Countries country, int height, Colors color, int quantity) {
        super(name, price, country, quantity);
        this.height = height;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public Colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getName() +
                "\t: price - " + getPrice() +
                ", country  - " + getCountry() +
                ", height - " + getHeight() +
                ", color - " + getColor() +
                ", quantity available - " + getQuantity();
    }
}
