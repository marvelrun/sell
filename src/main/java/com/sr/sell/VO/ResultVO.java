package com.sr.sell.VO;

import lombok.Data;

/*
http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {

    private Integer code;//错误码

    private String message;//错误信息

    private T data;//内容
}
