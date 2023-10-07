package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private long orderId;
    private Integer pizzaName;
    private Integer pizzaSize;
    private Integer sous;
    private double price;
    private LocalDateTime startTime;
    private LocalDateTime deliveryTime;
    private  long customerId;
    private long courierId;
    private byte deliveryStatus;

    public Order(long orderId, Integer pizzaName, Integer pizzaSize, Integer sous, double price, LocalDateTime startTime, LocalDateTime deliveryTime, long customerId, long courierId, byte deliveryStatus) {
        this.orderId = orderId;
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;
        this.sous = sous;
        this.price = price;
        this.startTime = startTime;
        this.deliveryTime = deliveryTime;
        this.customerId = customerId;
        this.courierId = courierId;
        this.deliveryStatus = deliveryStatus;
    }

    public Order(long orderId, String pizzaName, String pizzaVolumeName, String sousName, BigDecimal bigDecimal, LocalDateTime now, LocalDateTime deliveryTime, Customer customer, Courier courier, boolean b) {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Integer getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(Integer pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Integer getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(Integer pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public Integer getSous() {
        return sous;
    }

    public void setSous(Integer sous) {
        this.sous = sous;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public byte getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(byte deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", pizzaName='" + pizzaName + '\'' +
                ", pizzaSize='" + pizzaSize + '\'' +
                ", sous='" + sous + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", deliveryTime=" + deliveryTime +
                ", customerId=" + customerId +
                ", courierId=" + courierId +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}