package com.frozen.rpcserverapi.vo.req;

import com.frozen.rpccommon.req.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2018/05/21 15:56
 * @since JDK 1.8
 */
@Data
@ToString
@AllArgsConstructor
public class SendMsgReqVO extends BaseRequest {
    private String msg ;
    private Long userId ;
}
