package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import helperService.CustomerHelperService;
import model.Customer;
import service.CustomerManagementService;
import service.LoginService;
import util.InputUtil;

public class LoginServiceImpl implements LoginService {
    @Override
    public void login() {
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        System.out.println("-------------| Welcome to Login Menu |--------------");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        boolean hasExist = true;
        for (Customer customer : GlobalData.customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                customerManagementService.manage(customer);
                hasExist = false;
            }
        }
        if(hasExist){
            throw new ApplicationException(ExceptionEnum.CUSTOMER_NOT_FOUND_EXCEPTION);
        }
    }

    @Override
    public void signUp() {
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        System.out.println("-------------| Welcome to Sign Up Menu |--------------");
        Customer customer = CustomerHelperService.fillCustomer();
        if (customer == null) {
            throw new NullPointerException("Null customer");
        }
        for (Customer hasCustomer : GlobalData.customers) {
            if (customer.getEmail().equals(hasCustomer.getEmail())) {
                throw new ApplicationException(ExceptionEnum.ALREADY_EXIST_EXCEPTION);
            }
        }

        GlobalData.customers.add(customer);
        customerManagementService.manage(customer);

    }
}