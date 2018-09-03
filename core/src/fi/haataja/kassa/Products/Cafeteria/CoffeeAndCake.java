package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class CoffeeAndCake extends Product {

    public CoffeeAndCake(String time) {
        super(time, "Kahvi ja leivos");
        setPrice(2);
        CATEGORY = 1;
    }
}
