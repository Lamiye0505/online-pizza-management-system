package model;

import java.time.LocalDateTime;

public class Customer {
    private long customerId ;
    private String name;
    private String surname ;
    private String phoneNumber ;
    private String email ;
    private String password;
    private double moneyAccount;
    private LocalDateTime registrationDate;
    private long orderId;
    private byte status ;

    public Customer(long customerId, String name, String surname, String phoneNumber, String email, String password, double moneyAccount, LocalDateTime registrationDate, long orderId, byte status) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.moneyAccount = moneyAccount;
        this.registrationDate = registrationDate;
        this.orderId = orderId;
        this.status = status;
    }
    public boolean makePayment(double amount) {
        if (moneyAccount >= amount) {
            moneyAccount -= amount;
            return true;
        } else {
            return false;
        }
    }


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", moneyAccount=" + moneyAccount +
                ", registrationDate=" + registrationDate +
                ", orderId=" + orderId +
                ", status=" + status +
                '}';
    }
}