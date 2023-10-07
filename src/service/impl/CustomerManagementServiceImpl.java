package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import helperService.HelperService;
import model.Customer;
import service.CustomerManagementService;
import service.CustomerService;
import service.LoginManagementService;
import util.MenuUtil;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void manage(Customer customer) {
        CustomerService customerService = new CustomerServiceImpl();
        LoginManagementService loginManagementService = new LoginManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().loginMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        loginManagementService.manage();
                        break;
                    case 2:
                        HelperService.checkDeliveryTime();
                        ((CustomerServiceImpl) customerService).placeOrder(customer);
                        break;
                    case 3:
                        customerService.trackOrder(customer);
                        break;
                    case 4:
                        customerService.cancelOrder(customer);
                        break;
                    case 5:
                        customerService.increaseMoney(customer);
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

}