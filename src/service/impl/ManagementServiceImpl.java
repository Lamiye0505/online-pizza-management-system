package service.impl;

import enums.ExceptionEnum;
import exception.ApplicationException;
import helperService.AdminHelperService;
import service.LoginManagementService;
import service.ManagementService;
import util.MenuUtil;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void manage() {
        LoginManagementService loginManagementService = new LoginManagementServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.getInstance().entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        AdminHelperService.adminLogin();
                        break;
                    case 2:
                        loginManagementService.manage();
                        break;
                    default: throw new ApplicationException(ExceptionEnum.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }

    }
}