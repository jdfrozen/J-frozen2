package com.frozen.rpccommon.req;


import lombok.Data;
import lombok.ToString;

/**
 * Function:
 * @author crossoverJie
 * Date: 2017/6/7 下午11:28
 * @since JDK 1.8
 */
@Data
@ToString
public class BaseRequest {
    private String reqNo;
    private int timeStamp;
    public BaseRequest() {
        this.setTimeStamp((int)(System.currentTimeMillis() / 1000));
    }
}
