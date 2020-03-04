package ca.sfu.sell.service;

import ca.sfu.sell.dataobject.OrderMaster;
import ca.sfu.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    /** create an order */
    OrderDTO create(OrderDTO orderDTO);

    /** search an order */
    OrderDTO findOne(String orderId);

    /** search order list */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** cancel order */
    OrderDTO cancel(OrderDTO orderDTO);

    /** finish an order */
    OrderDTO finish(OrderDTO orderDTO);

    /** pay an order */
    OrderDTO pay(OrderDTO orderDTO);
}
