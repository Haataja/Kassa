package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Cake extends Product {
    public Cake(String time, String name) {
        super(time, name);
        CATEGORY = 1;
    }
}
