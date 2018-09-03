package fi.haataja.kassa.Products.MiniatureTournaments;

import fi.haataja.kassa.Products.Product;

public class Warhammer extends Product {

    public Warhammer(String time) {
        super(time, "Warhammer");
        setPrice(10);
        CATEGORY = 0;
    }
}
