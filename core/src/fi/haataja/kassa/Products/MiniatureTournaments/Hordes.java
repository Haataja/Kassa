package fi.haataja.kassa.Products.MiniatureTournaments;

import fi.haataja.kassa.Products.Product;

public class Hordes extends Product {

    public Hordes(String time) {
        super(time, "Warmachine/Hordes");
        setPrice(10);
        CATEGORY = 0;
    }
}
