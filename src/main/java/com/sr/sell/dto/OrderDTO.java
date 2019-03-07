package com.sr.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sr.sell.dataobject.OrderDetail;
import com.sr.sell.enums.OrderStatusEnum;
import com.sr.sell.enums.PayStatusEnum;
import com.sr.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;//订单id

    private String buyerName;//买家名字

    private String buyerPhone;//买家电话

    private String buyerAddress;//买家地址

    private String buyerOpenid;//买家Openid

    private BigDecimal orderAmount;//订单总金额

    private Integer orderStatus;//订单状态

    private Integer payStatus;//支付状态

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;//创建时间

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;//更新时间

    List<OrderDetail> orderDetailList;
}
