package enums;

import java.math.BigDecimal;

public enum Sous {
    KETCUP(1,"Ketcup",0.7),
    BARBECUE(2,"Barbecue",0.7),
    MAYONNAISE(3,"Mayonnaise",0.7);
    private final String name;
    private final BigDecimal price;
    private final long id;

    Sous(long id, String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }
}