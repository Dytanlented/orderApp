package ca.sfu.sell.controller;


import ca.sfu.sell.VO.ResultVO;
import ca.sfu.sell.converter.OrderFormToOrderDTOConverter;
import ca.sfu.sell.dto.OrderDTO;
import ca.sfu.sell.enums.ResultEnum;
import ca.sfu.sell.exception.SellException;
import ca.sfu.sell.form.OrderForm;
import ca.sfu.sell.service.OrderService;
import ca.sfu.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //create an order
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("create order failed, arguments not right, orderFrom={}",orderForm);
            throw new SellException(ResultEnum.PARA_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFormToOrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("cart can not be empty");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    //order list
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size) {
        if(StringUtils.isEmpty(openid)){
            log.error("search order list failed, openid is empty");
            throw new SellException(ResultEnum.PARA_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        return ResultVOUtil.success(orderDTOPage.getContent());

    }

    //order detail

    //cancel order

}
