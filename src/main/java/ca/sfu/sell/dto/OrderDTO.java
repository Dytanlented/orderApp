package ca.sfu.sell.dto;

import ca.sfu.sell.dataobject.OrderDetail;
import ca.sfu.sell.enums.OrderStatusEnum;
import ca.sfu.sell.enums.PayStatusEnum;
import ca.sfu.sell.utils.serializer.DateToLongSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    // order id
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
    private Integer orderStatus ;

    // payment status, default unpaid
    private Integer payStatus ;

    //createTime
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    //updateTime
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
