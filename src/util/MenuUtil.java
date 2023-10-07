package util;

public class MenuUtil {
    private static MenuUtil instance;

    private MenuUtil() {
    }

    public static MenuUtil getInstance() {
        return instance == null ? instance = new MenuUtil() : instance;
    }

    public byte entryMenu() {
        System.out.println("[0] - > Exit \n" +
                "[1] - > Admin \n" +
                "[2] - > Customer\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte adminMenu() {
        System.out.println("[0] - > Exit \n" +
                "[1] - > Back \n" +
                "[2] - > Add Courier \n" +
                "[3] - > Track Orders \n" +
                "[4] - > View Couriers \n" +
                "[5] - > View Customers\n" +
                "[6] - > View Restaurant");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte customerMenu() {
        System.out.println("  [0] - > Exit \n" +
                "  [1] - > Login \n" +
                "  [2] - > Sing up\n" +
                "  [3] - > Back \n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte loginMenu() {
        System.out.println(" [0] - > Exit \n" +
                " [1] - > Back \n" +
                " [2] - > Place Order \n" +
                " [3] - > Track Orders \n" +
                " [4] - > Cancel Order\n" +
                " [5] - > Increase Money");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

    public byte paymentMenu() {
        System.out.println("[1] - > Make the payment\n" +
                "[2] - > Cancel order\n");
        return InputUtil.getInstance().inputByte("Choose option: ");
    }

}