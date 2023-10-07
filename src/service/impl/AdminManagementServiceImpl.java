package service.impl;
import enums.ExceptionEnum;
import exception.ApplicationException;
import service.AdminManagementService;
import service.AdminService;
import service.ManagementService;
import util.MenuUtil;

public class AdminManagementServiceImpl implements AdminManagementService {
    @Override
    public void manage() {
        AdminService adminService = new AdminServiceImpl();
        ManagementService managementService = new ManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().adminMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        managementService.manage();
                        break;
                    case 2:
                        adminService.addCourier();
                        break;
                    case 3:
                        adminService.trackOrders();
                        break;
                    case 4:
                        adminService.viewCouriers();
                        break;
                    case 5:
                        adminService.viewCustomers();
                        break;
                    case 6:
                        adminService.viewRestaurant();
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