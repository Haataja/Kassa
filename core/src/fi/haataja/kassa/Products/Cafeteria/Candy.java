package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Candy extends Product {
    public Candy(String time, String name) {
        super(time, name);
        CATEGORY = 1;
    }
}
