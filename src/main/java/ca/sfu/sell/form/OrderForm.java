package ca.sfu.sell.form;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class OrderForm {

    /**
     * buyer name
     */
    @NotEmpty(message = "Name required")
    private String name;

    /**
     * buyer phone
     */
    @NotEmpty(message = "Phone required")
    private String phone;

    /**
     * buyer address
     */
    @NotEmpty(message = "Address required")
    private String address;

    /**
     * buyer wechat id
     */
    @NotEmpty(message = "Openid required")
    private String openid;

    /**
     * cart
     */
    @NotEmpty(message = "Cart is empty")
    private String items;


}
