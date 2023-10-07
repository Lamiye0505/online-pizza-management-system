package enums;

import java.math.BigDecimal;

public enum Pizza {
    ITALIANO(1, "Italiano", 11.99),
    AMERICANO(2, "Americano", 10.99),
    MEXICANO(3, "Mexicano", 12.99),
    CHICKEN_KICKERS(4, "Chicken kickers", 9.99),
    MARGHERITA(5, "Margherita", 13.99),
    PEPPERONI(6, "Pepperoni", 14.99);
    private final long id;
    private final String name;
    private final BigDecimal price;

    Pizza(long id,String name, double price) {
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