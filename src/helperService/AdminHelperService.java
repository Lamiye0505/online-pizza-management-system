package helperService;

import data.AdminData;
import enums.ExceptionEnum;
import exception.ApplicationException;
import service.AdminManagementService;
import service.impl.AdminManagementServiceImpl;
import util.InputUtil;

public class AdminHelperService {
    public static void adminLogin() {
        AdminManagementService adminManagementService = new AdminManagementServiceImpl();
        String username = InputUtil.getInstance().inputString("Enter the username: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        if(username.equals(AdminData.username) && password.equals(AdminData.password)){
            adminManagementService.manage();
        }else {
            throw new ApplicationException(ExceptionEnum.WRONG_USERNAME_OR_PASSWORD_EXCEPTION);
        }
    }
}