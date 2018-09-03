package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Sandwich extends Product {

    public Sandwich(String time, String name) {
        super(time, name);
        CATEGORY = 1;
    }
}
