package ca.sfu.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"Product does not exist"),
    PRODUCT_STOCK_ERROR(11,"Stock error"),
    ORDER_NOT_EXIST(12,"Order does not exist"),
    ORDER_DETAIL_NOT_EXIST(13,"Order detail does not exist"),
    ORDER_STATUS_ERROR(14,"Order status is not right"),
    ORDER_UPDATE_FAIL(15,"Update order failed"),
    ORDER_DETAIL_EMPTY(16,"Order detail is empty"),
    PAY_STATUS_ERROR(17,"Already paid"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
