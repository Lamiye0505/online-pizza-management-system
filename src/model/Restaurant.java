package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String location;
    private BigDecimal totalAmount;
    private List<Order> orders;
    private static Restaurant instance;
    private Restaurant(){
        this.name = "CabbarovsFamilyDelivery";
        this.location = "Azerbaijan/Baku";
        this.orders = new ArrayList<>();
        this.totalAmount = new BigDecimal(0);
    }

    public static Restaurant getInstance() {
        return instance == null ? instance = new Restaurant() : instance;

    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders.add(orders);
    }

    public static void setInstance(Restaurant instance) {
        Restaurant.instance = instance;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}