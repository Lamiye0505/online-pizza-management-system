package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import service.LoginManagementService;
import service.LoginService;
import service.ManagementService;
import util.MenuUtil;

public class LoginManagementServiceImpl implements LoginManagementService {
    @Override
    public void manage() {
        LoginService loginService = new LoginServiceImpl();
        ManagementService managementService = new ManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().customerMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        loginService.login();
                        break;
                    case 2:
                        loginService.signUp();
                        break;
                    case 3:
                        managementService.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }}
}