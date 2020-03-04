package ca.sfu.sell.repository;

import ca.sfu.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired OrderDetailRepository repository;

    @Test
    public void  saveTest(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567");
        orderDetail.setOrderId("9757");
        orderDetail.setProductIcon("https://xxxx.com");
        orderDetail.setProductId("98767");
        orderDetail.setProductName("小麻辣烫");
        orderDetail.setProductPrice(new BigDecimal(23.3));
        orderDetail.setProductQuantity(26);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList =  repository.findByOrderId("9757");
        Assert.assertNotEquals(0,orderDetailList.size());

    }
}