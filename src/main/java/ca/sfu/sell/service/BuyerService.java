package ca.sfu.sell.service;

import ca.sfu.sell.dto.OrderDTO;

public interface BuyerService {
    //track order
    OrderDTO findOrderOne(String openid, String orderId);


    //cancel order
    OrderDTO cancelOrder(String openid, String orderId);

}
