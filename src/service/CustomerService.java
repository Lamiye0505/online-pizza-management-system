package service;

import model.Customer;
import model.Order;
import response.BaseResponse;

public interface CustomerService {
    BaseResponse<Order> placeOrder(Customer customer);
    void trackOrder(Customer customer);
    BaseResponse<Order> cancelOrder(Customer customer);
    void increaseMoney(Customer customer);
}