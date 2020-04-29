package com.frozen.rpcserver.controller;

import com.frozen.rpccommon.res.BaseResponse;
import com.frozen.rpcserverapi.ISendMsgServerApi;
import com.frozen.rpcserverapi.vo.req.SendMsgReqVO;
import com.frozen.rpcserverapi.vo.res.SendMsgResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Frozen
 * @create: 2020-04-29 14:08
 * @description:
 **/
@RestController
@Slf4j
public class SendMsgServerApi implements ISendMsgServerApi {

	@Override
	@RequestMapping(value = "/sendMsg")
	@ResponseBody
	public BaseResponse<SendMsgResVO> sendMsg(@RequestBody SendMsgReqVO sendMsgReqVO) throws Exception {
		return BaseResponse.createSuccess(new SendMsgResVO("echo："+sendMsgReqVO.getMsg()));
	}
}
