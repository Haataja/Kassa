package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class Coffee extends Product {

    public Coffee(String time){
        super(time, "Kahvi / Tee");
        setPrice(1f);
        CATEGORY = 1;
    }
}
