package com.sr.sell.service.Impl;

import com.sr.sell.dto.OrderDTO;
import com.sr.sell.service.OrderService;
import com.sr.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDTO orderDTO=orderService.findOne("1548229529989722828");
        payService.create(orderDTO);
    }
    @Test
    public void refund(){
        OrderDTO orderDTO=orderService.findOne("1548229529989722828");
        payService.refund(orderDTO);
    }
}