package ca.sfu.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    // product id
    private String orderId;

    // product id
    private String productId;

    // product name
    private String productName;

    // unit price
    private BigDecimal productPrice;

    // product quantity
    private Integer productQuantity;

    // product icon
    private String productIcon;


}
