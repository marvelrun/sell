package com.sr.sell.controller;

import com.sr.sell.VO.ProductInfoVO;
import com.sr.sell.VO.ProductVO;
import com.sr.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO=new ResultVO();
        ProductInfoVO productInfoVO =new ProductInfoVO();
        ProductVO productVO=new ProductVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));
        resultVO.setCode(0);
        resultVO.setMessage("成功");

        return resultVO;
    }
}
