package com.sr.sell.Exception;

import com.sr.sell.enums.ResultEnum;

public class SellException extends RuntimeException{
    Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code=code;
    }
}
