package service;

import model.Courier;
import model.Customer;
import model.Order;
import model.Restaurant;
import response.BaseResponse;

import java.util.List;

public interface AdminService {
    BaseResponse<Courier> addCourier();
    BaseResponse<List<Order>> trackOrders();
    BaseResponse<List<Courier>> viewCouriers();
    BaseResponse<List<Customer>> viewCustomers();
    BaseResponse<Restaurant> viewRestaurant();
}