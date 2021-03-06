package ca.sfu.sell.exception;

import ca.sfu.sell.enums.ResultEnum;

public class SellException extends RuntimeException{
    private Integer code;

    private  String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
