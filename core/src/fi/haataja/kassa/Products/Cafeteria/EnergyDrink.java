package fi.haataja.kassa.Products.Cafeteria;

import fi.haataja.kassa.Products.Product;

public class EnergyDrink extends Product {

    public EnergyDrink(String time) {
        super(time, "Energiajuoma");
        setPrice(1.5f);
        CATEGORY = 1;
    }
}
