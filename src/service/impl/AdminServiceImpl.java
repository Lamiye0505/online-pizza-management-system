package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helperService.CourierHelperService;
import model.Courier;
import model.Customer;
import model.Order;
import model.Restaurant;
import response.BaseResponse;

import java.util.List;

public class AdminServiceImpl implements service.AdminService {
    @Override
    public BaseResponse<Courier> addCourier() {
        Courier courier = CourierHelperService.fillCourier();
        if(courier != null){
            GlobalData.couriers.add(courier);
            return new BaseResponse<Courier>().of(200,"Success",courier);
        }else {
            throw new ApplicationException(ExceptionEnum.NULL_COURIER_EXCEPTION);
        }
    }

    @Override
    public BaseResponse<List<Order>> trackOrders() {
        if(GlobalData.orders.isEmpty()){
            throw new ApplicationException(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION);
        }
        for (Order order:GlobalData.orders) {
            System.out.println(order);
        }
        return new BaseResponse<List<Order>>().of(200,"Success",GlobalData.orders);
    }

    @Override
    public BaseResponse<List<Courier>> viewCouriers() {
        if(GlobalData.couriers.isEmpty()){
            throw new ApplicationException(ExceptionEnum.COURIER_NOT_FOUND_EXCEPTION);
        }
        for (Courier courier:GlobalData.couriers) {
            System.out.println(courier);
        }
        return new BaseResponse<List<Courier>>().of(200,"Success",GlobalData.couriers);
    }

    @Override
    public BaseResponse<List<Customer>> viewCustomers() {
        if(GlobalData.customers.isEmpty()){
            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
        }
        for (Customer customer:GlobalData.customers) {
            System.out.println(customer);
        }
        return new BaseResponse<List<Customer>>().of(200,"Success",GlobalData.customers);
    }

    @Override
    public BaseResponse<Restaurant> viewRestaurant() {
        Restaurant restaurant = Restaurant.getInstance();
        System.out.println(restaurant);
        return new BaseResponse<Restaurant>().of(200,"Success",restaurant);
    }
}