package enums;

import java.math.BigDecimal;

public enum Volume {
    SMALL(1,"Small",0),
    MEDIUM(2,"Medium",6.99),
    LARGE(3,"Large",13.99);

    private final String name;
    private final BigDecimal price;
    private final long id;

    Volume(long id, String name, double price) {
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