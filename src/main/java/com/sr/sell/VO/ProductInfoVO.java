package com.sr.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class ProductInfoVO {
    @JsonProperty("id")
    private String productId;//商品ID

    @JsonProperty("name")
    private String productName;//商品名称

    @JsonProperty("price")
    private BigDecimal productPrice;//单价

    @JsonProperty("stock")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
