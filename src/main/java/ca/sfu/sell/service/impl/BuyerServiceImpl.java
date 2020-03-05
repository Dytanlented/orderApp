package ca.sfu.sell.service.impl;

import ca.sfu.sell.dto.OrderDTO;
import ca.sfu.sell.enums.ResultEnum;
import ca.sfu.sell.exception.SellException;
import ca.sfu.sell.service.BuyerService;
import ca.sfu.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;



    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("cancel order failed,no such order, orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("track order failed , not the same openid, orderDTO={},openid={}",orderDTO,openid);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
