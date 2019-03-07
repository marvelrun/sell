package com.sr.sell.controller;

import com.sr.sell.Exception.SellException;
import com.sr.sell.VO.ResultVO;
import com.sr.sell.converter.OrderForm2OrderDTOConverter;
import com.sr.sell.dto.OrderDTO;
import com.sr.sell.enums.ResultEnum;
import com.sr.sell.form.OrderForm;
import com.sr.sell.service.BuyerService;
import com.sr.sell.service.OrderService;
import com.sr.sell.utils.ResultVOUtils;
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
    @Autowired
    private BuyerService buyerService;
    //创建订单
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO=OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult=orderService.create(orderDTO);
        Map<String ,String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtils.success(map);
    }

    //订单列表
    @GetMapping("/list")
        public ResultVO<List<OrderDTO>> list(
        @RequestParam("openid")String openid,
        @RequestParam(value = "page",defaultValue = "0")Integer page,
        @RequestParam(value = "size",defaultValue = "10")Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage= orderService.findList(openid,pageRequest);

        return ResultVOUtils.success(orderDTOPage.getContent());
        }
    //订单详情
    @GetMapping("detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid")String openid,
                                     @RequestParam("orderId")String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        return ResultVOUtils.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtils.success();
    }
}
