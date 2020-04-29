package com.frozen.rpcclient.controller;

import com.frozen.rpcclient.service.ClientApiService;
import com.frozen.rpccommon.res.BaseResponse;
import com.frozen.rpcserverapi.vo.res.SendMsgResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Frozen
 * @create: 2020-04-29 14:08
 * @description:
 **/
@RestController
@Slf4j
public class ClientApiController {
	@Autowired
	private ClientApiService clientApiService;

	@RequestMapping(value = "/sendMsg")
	public BaseResponse<SendMsgResVO> sendMsg(String msg) throws Exception {
		return clientApiService.sendMsg(msg);
	}
}
