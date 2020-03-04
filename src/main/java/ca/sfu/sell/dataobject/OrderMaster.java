package ca.sfu.sell.dataobject;


import ca.sfu.sell.enums.OrderStatusEnum;
import ca.sfu.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    // order id
    @Id
    private String orderId;

    // buyer name
    private String buyerName;

    // buyer phone
    private String buyerPhone;

    // buyer address
    private String buyerAddress;

    // buyer wechat id
    private String buyerOpenid;

    //order total amount
    private BigDecimal orderAmount;

    // order status,default new order
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // payment status, default unpaid
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //createTime
    private Date createTime;

    //updateTime
    private Date updateTime;


}
