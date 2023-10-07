package helperService;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.Pizza;
import enums.Sous;
import enums.Volume;
import exception.ApplicationException;
import model.Courier;
import model.Customer;
import model.Order;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class HelperService {
    public static long orderId;

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static Order returnOrder(byte pizza, byte pizzaVolume, byte sous, double orderPrice, Customer customer, Courier courier) {
        String pizzaName = null;
        String pizzaVolumeName = null;
        String sousName = null;
        for (Pizza pizzas : Pizza.values()) {
            if (pizzas.getId() == pizza) {
                pizzaName = pizzas.getName();
            }
        }
        for (Volume volumes : Volume.values()) {
            if (volumes.getId() == pizzaVolume) {
                pizzaVolumeName = volumes.getName();
            }
        }
        for (Sous souses : Sous.values()) {
            if (souses.getId() == sous) {
                sousName = souses.getName();
            }
        }

        return new Order(++orderId,pizzaName,pizzaVolumeName,sousName, BigDecimal.valueOf(orderPrice),HelperService.now(),HelperService.now().plusHours(1),customer,courier,true);
    }

    public static boolean isNegative(LocalDateTime deliveryTime) {
        Duration duration = Duration.between(LocalDateTime.now(),deliveryTime.minusMinutes(30));
        return duration.isNegative();
    }




    public static boolean isNegativeForCheckCourier(LocalDateTime deliveryTime){
        Duration duration = Duration.between(LocalDateTime.now(),deliveryTime);
        return duration.isNegative();

    }

}