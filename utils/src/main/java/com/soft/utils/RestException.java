package com.soft.utils;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName:     RestException
 * <p>Description:   restApi返回错误码消息结构
 * <p>Version        V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class RestException extends RuntimeException {
    private Integer resultCode;
    private String resultMsg;
    private List data = new ArrayList();

    public RestException(String resultMsg) {
        super(resultMsg);
        this.setResultCode(RestExceptionResultCodeEnum.UNKNOWN.getValue());
        this.setResultMsg(resultMsg);
    }

    public RestException(RestExceptionResultCodeEnum resultCodeEnum, String resultMsg) {
        super(resultMsg);
        this.setResultCode(resultCodeEnum.getValue());
        this.setResultMsg(resultMsg);
    }

    public RestException(RestExceptionResultCodeEnum resultCodeEnum, String resultMsg, List dataList) {
        super(resultMsg);
        this.setResultCode(resultCodeEnum.getValue());
        this.setResultMsg(resultMsg);
        this.setData(dataList);
    }
}
