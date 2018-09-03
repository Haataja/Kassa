package fi.haataja.kassa.Products.ConsoleTournaments;

import fi.haataja.kassa.Products.Product;

public class MeleeSingles extends Product {

    public MeleeSingles(String time) {
        super(time, "SSB Melee Singles");
        setPrice(10);
        CATEGORY = 0;
    }
}
