package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helperService.CustomerHelperService;
import helperService.HelperService;
import model.Courier;
import model.Customer;
import model.Order;
import model.Restaurant;
import response.BaseResponse;
import service.CustomerService;
import util.InputUtil;
import util.MenuUtil;

import java.math.BigDecimal;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public BaseResponse<Order> placeOrder(Customer customer) {
        byte pizza = CustomerHelperService.choosePizza();
        byte pizzaVolume = CustomerHelperService.choosePizzaVolume();
        byte sous = CustomerHelperService.chooseSous();
        double orderPrice = CustomerHelperService.calculateOrder(pizza, pizzaVolume, sous);
        System.out.println("Order payment: " + orderPrice);
        byte option = MenuUtil.getInstance().paymentMenu();
        if (option == 1) {
            if (customer.getMoneyAccount().doubleValue() < orderPrice) {
                throw new ApplicationException(ExceptionEnum.LOW_MONEY_EXCEPTION);
            }


            if (CustomerHelperService.hasCustomer(customer)) {
                customer.setMoneyAccount(BigDecimal.valueOf(customer.getMoneyAccount().doubleValue() - orderPrice));
                Courier courier = CustomerHelperService.searchCourier();
                Order order = CustomerHelperService.finishOrder(pizza, pizzaVolume, sous, orderPrice, customer, courier);
                CustomerHelperService.cashReceipt(order);
                return new BaseResponse<Order>().of(200, "Success", order);
            }else {

                customer.setMoneyAccount(BigDecimal.valueOf(customer.getMoneyAccount().doubleValue() - orderPrice));
                Courier courier = CustomerHelperService.searchCourier();
                Order order = CustomerHelperService.finishOrder(pizza, pizzaVolume, sous, orderPrice, customer, courier);
                CustomerHelperService.cashReceiptForFirstOrder(order);
                return new BaseResponse<Order>().of(200, "Success", order);
            }
        }
        return null;
    }

    @Override
    public void trackOrder(Customer customer) {
        if (GlobalData.orders.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION);
        }
        for (Order order : GlobalData.orders) {
            if (order.getCustomer().equals(customer) && order.isDeliveryStatus()) {
                System.out.println(order);
            }
        }
    }

    @Override
    public BaseResponse<Order> cancelOrder(Customer customer) {
        if (GlobalData.orders.isEmpty()) {
            throw new ApplicationException(ExceptionEnum.ORDER_NOT_FOUND_EXCEPTION);
        }
        for (Order order : GlobalData.orders) {
            if (order.getCustomer().equals(customer) && order.isDeliveryStatus()) {
                if (!HelperService.isNegative(order.getDeliveryTime())) {
                    customer.setMoneyAccount(BigDecimal.valueOf(customer.getMoneyAccount().doubleValue() + order.getPrice().doubleValue()));
                    order.setDeliveryStatus(false);
                    order.getCourier().setAvailabilityStatus(false);
                    Restaurant restaurant = Restaurant.getInstance();
                    restaurant.setTotalAmount(BigDecimal.valueOf(restaurant.getTotalAmount().doubleValue() - order.getPrice().doubleValue()));
                    return new BaseResponse<Order>().of(200, "Success", order);
                }
            }
        }
        return null;
    }

    @Override
    public void increaseMoney(Customer customer) {
        int money = InputUtil.getInstance().inputInt("Enter the money: ");
        customer.setMoneyAccount(BigDecimal.valueOf(customer.getMoneyAccount().doubleValue() + money));
    }
}