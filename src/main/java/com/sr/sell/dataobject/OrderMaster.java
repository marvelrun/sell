package com.sr.sell.dataobject;

import com.sr.sell.enums.OrderStatusEnum;
import com.sr.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;//订单id

    private String buyerName;//买家名字
    private String buyerPhone;//买家电话
    private String buyerAddress;//买家地址
    private String buyerOpenid;//买家Openid
    private BigDecimal orderAmount;//订单总金额
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();//订单状态
    private Integer payStatus= PayStatusEnum.WAIT.getCode();//支付状态
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

}
