package fi.haataja.kassa.Products.MiniatureTournaments;

import fi.haataja.kassa.Products.Product;

public class GuildBall extends Product {

    public GuildBall(String time) {
        super(time, "Guild Ball");
        setPrice(5);
        CATEGORY = 0;
    }
}
