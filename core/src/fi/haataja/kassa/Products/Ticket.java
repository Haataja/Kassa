package fi.haataja.kassa.Products;

public class Ticket extends Product {

    public Ticket(String time) {
        super(time, "Sisäänpääsy");
        setPrice(5);
        CATEGORY = 0;
    }
}
