package com.sr.sell.enums;

import lombok.Data;
import lombok.Getter;

import javax.management.loading.MLetContent;

@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已完结"),
    ;
    private Integer code;
    private String message;
    OrderStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
