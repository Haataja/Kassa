package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Chocolate extends Product {
    public Chocolate(String time) {
        super(time, "Snickers");
        setPrice(1f);
        CATEGORY = 1;
    }
}
