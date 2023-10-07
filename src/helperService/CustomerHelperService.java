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
import util.InputUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerHelperService {
    private static long customerId;

    public static Customer fillCustomer() {
        try {
            String name = InputUtil.getInstance().inputString("Enter the name: ");
            String surname = InputUtil.getInstance().inputString("Enter the surname: ");
            String phoneNumber = InputUtil.getInstance().inputString("Enter the phoneNumber: ");
            String email = InputUtil.getInstance().inputString("Enter the email: ");
            alreadyExistEmail(email);
            String password = InputUtil.getInstance().inputString("Enter the password: ");
            LocalDate birthday = birthdayFormat();
            return new Customer(++customerId, name, surname, phoneNumber, email, password, 0, BigDecimal.valueOf(0), HelperService.now(), 1, birthday);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static LocalDate birthdayFormat() {
        try {
            String stringBirthday = InputUtil.getInstance().inputString("Enter the birthday(dd/MM/YYYY): ");
            String[] splitBirthday = stringBirthday.split("/");
            byte day = (byte) Integer.parseInt(splitBirthday[0]);
            byte month = (byte) Integer.parseInt(splitBirthday[1]);
            int years = Integer.parseInt(splitBirthday[2]);
            return LocalDate.of(years, month, day);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    private static void alreadyExistEmail(String email) {
        if (!GlobalData.customers.isEmpty()) {
            for (Customer customer : GlobalData.customers) {
                if (customer.getEmail().equals(email)) {
                    throw new ApplicationException(ExceptionEnum.ALREADY_EXIST_EXCEPTION);
                }
            }
        }
    }

    public static byte choosePizza() {
        System.out.println("----------|  Pizzanın növun daxil et |-----------\n" +
                "Pizalar : ( Italiano -> 11.99 azn , Americano -> 10.99 azn , Mexicano -> 12.99azn ,Chiscken Kickers -> 9.99azn , Margherita -> 13.99 azn , Pepperoni -> 14.99azn )\n" +
                "\n" +
                "[1] -> Italiano  \n" +
                "[2] -> Americano\n" +
                "[3] -> Mexicano\n" +
                "[4] -> Chicken Kickers\n" +
                "[5] -> Margherita\n" +
                "[6] ->Pepperoni\n");
        return InputUtil.getInstance().inputByte("Choose Pizza: ");
    }

    public static byte choosePizzaVolume() {
        System.out.println("    ---------| Pizanin hecimi |-------------\n" +
                "Hecmler ( kicik(default) , orta (+6.99azn) , boyuk (+13.99azn) )\n" +
                "\n" +
                "[1] -> Small  \n" +
                "[2] -> Medium\n" +
                "[3] -> Large\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public static byte chooseSous() {
        System.out.println(" ------------| Sous |-------------\n" +
                "\t\tSous ( Ketcup - > 0.7azn , Barbecu - > 0.7 azn ,  Mayonnaise - > 0.7 )\n" +
                "[1] -> Ketcup \n" +
                "[2] -> Barbecu\n" +
                "[3] -> Mayonnaise\n" +
                "[4] -> Cancel\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public static double calculateOrder(byte pizza, byte pizzaVolume, byte sous) {
        double pizzaPrice = 0;
        double pizzaVolumePrice = 0;
        double pizzaSous = 0;
        for (Pizza pizzas : Pizza.values()) {
            if (pizzas.getId() == pizza) {
                pizzaPrice = pizzas.getPrice().doubleValue();
            }
        }
        for (Volume volume : Volume.values()) {
            if (volume.getId() == pizzaVolume) {
                pizzaVolumePrice = volume.getPrice().doubleValue();
            }
        }
        for (Sous souses : Sous.values()) {
            if (souses.getId() == sous) {
                pizzaSous = souses.getPrice().doubleValue();
            }
        }
        return pizzaPrice + pizzaVolumePrice + pizzaSous;
    }

    public static Courier searchCourier() {
        for (Courier courier : GlobalData.couriers) {
            if (!courier.isAvailabilityStatus()) {
                courier.setAvailabilityStatus(true);
                return courier;
            }
        }
        return null;
    }

    public static Order finishOrder(byte pizza, byte pizzaVolume, byte sous, double orderPrice, Customer customer, Courier courier) {
        Order order = HelperService.returnOrder(pizza, pizzaVolume, sous, orderPrice, customer, courier);
        GlobalData.orders.add(order);
        GlobalData.restaurant.setOrders(order);
        GlobalData.restaurant.setTotalAmount(BigDecimal.valueOf(GlobalData.restaurant.getTotalAmount().doubleValue() + orderPrice));
        return order;
    }

    public static void cashReceipt(Order order) {

    }

    public static void cashReceiptForBirthday(Order order) {

    }

    public static void cashReceiptForFirstOrder(Order order) {

    }

    public static boolean hasCustomer(Customer customer) {

    }






