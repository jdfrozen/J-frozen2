package com.frozen.rpcserverapi;


import com.frozen.rpccommon.res.BaseResponse;
import com.frozen.rpcserverapi.vo.req.SendMsgReqVO;
import com.frozen.rpcserverapi.vo.res.SendMsgResVO;

/**
 * Function:
 *
 * @author crossoverJie
 * Date: 2020-04-25 14:23
 * @since JDK 1.8
 */
public interface ISendMsgServerApi {

    /**
     * Push msg to client
     * @param sendMsgReqVO
     * @return
     * @throws Exception
     */
    Object sendMsg(SendMsgReqVO sendMsgReqVO) throws Exception;
}
