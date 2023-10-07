package enums;

import java.time.LocalDateTime;

public enum ExceptionEnum {
    CUSTOMER_NOT_FOUND_EXCEPTION("Customer not found", LocalDateTime.now()),
    COURIER_NOT_FOUND_EXCEPTION("Courier not found", LocalDateTime.now()),
    ORDER_NOT_FOUND_EXCEPTION("Order not found", LocalDateTime.now()),
    NULL_COURIER_EXCEPTION("Null courier exception", LocalDateTime.now()),
    LOW_MONEY_EXCEPTION("Low money", LocalDateTime.now()),
    ALREADY_EXIST_EXCEPTION("Already exist", LocalDateTime.now()),
    INVALID_OPTION_EXCEPTION("Invalid option", LocalDateTime.now()),
    WRONG_USERNAME_OR_PASSWORD_EXCEPTION("Wrong username or password", LocalDateTime.now());
    private final String message;
    private final LocalDateTime exceptionTime;

    ExceptionEnum(String message, LocalDateTime exceptionTime) {
        this.message = message;
        this.exceptionTime = exceptionTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }
}