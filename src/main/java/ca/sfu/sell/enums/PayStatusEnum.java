package ca.sfu.sell.enums;


import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT(0,"Unpaid"),
    SUCCESS(1,"Paid"),
    ;


    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
