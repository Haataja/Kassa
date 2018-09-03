package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Juice extends Product {
    public Juice(String time) {
        super(time, "Trippi");
        setPrice(1f);
        CATEGORY = 1;
    }
}
