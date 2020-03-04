package ca.sfu.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"New order"),
    DELIVERED(1,"Delivered"),
    CANCELED(2,"Canceled"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
