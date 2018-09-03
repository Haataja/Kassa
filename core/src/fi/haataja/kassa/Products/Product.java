package fi.haataja.kassa.Products;

import java.util.Locale;

public abstract class Product {
    public int CATEGORY;
    private float price;
    private String time;
    private String name;

    public Product(String time, String name) {
        this.time = time;
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public void setTime(String time){this.time = time;}
    public String getTime() {
        return time;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%3.2f€", price);
    }
}
