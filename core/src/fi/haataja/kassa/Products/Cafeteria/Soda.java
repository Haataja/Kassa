package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Soda extends Product {
    public Soda(String time) {
        super(time, "Virvoitusjuoma");
        setPrice(2.5f);
        CATEGORY = 1;
    }
}
