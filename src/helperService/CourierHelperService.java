package helperService;

import model.Courier;
import util.InputUtil;

public class CourierHelperService {
    private static long courierId;
    public static Courier fillCourier(){
        try {
            String name = InputUtil.getInstance().inputString("Enter the courier name: ");
            String phoneNumber = InputUtil.getInstance().inputString("Enter the courier phoneNumber: ");
            String vehicleType = InputUtil.getInstance().inputString("Enter the courier vehicleType: ");
            String vehiclePlate = InputUtil.getInstance().inputString("Enter the courier vehiclePlate: ");
            return new Courier(++courierId,name,phoneNumber,vehicleType,vehiclePlate,0,0,false);
        }catch (RuntimeException e){

            return null;
        }
    }
}