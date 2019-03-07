package com.sr.sell.repository;

import com.sr.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class )
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("虾饺");
        productInfo.setProductPrice(new BigDecimal(16));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("本店特色虾饺");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> result=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
    }
}