package fi.haataja.kassa.Products.ConsoleTournaments;

import fi.haataja.kassa.Products.Product;

public class Tekken extends Product {

    public Tekken(String time) {
        super(time, "Tekken");
        setPrice(10);
        CATEGORY = 0;
    }
}
