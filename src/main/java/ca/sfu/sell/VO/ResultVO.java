package ca.sfu.sell.VO;


import lombok.Data;

@Data
public class ResultVO<T> {

    /** error code. */
    private Integer code;

    /** info. */
    private String message;

    /** details. */
    private T data;

}
