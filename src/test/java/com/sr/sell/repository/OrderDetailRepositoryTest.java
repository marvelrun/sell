package com.sr.sell.repository;

import com.sr.sell.dataobject.OrderDetail;
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
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductId("1112");
        orderDetail.setProductIcon("http:/XXXx.jpg");
        orderDetail.setProductName("咸骨粥");
        orderDetail.setProductPrice(new BigDecimal(8));
        orderDetail.setProductQuantity(1);
        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdTest(){
        List<OrderDetail> orderDetailList=repository.findByOrderId("1111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}