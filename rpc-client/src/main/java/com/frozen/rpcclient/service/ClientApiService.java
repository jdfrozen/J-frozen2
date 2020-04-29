package com.frozen.rpcclient.service;

import com.alibaba.fastjson.JSON;
import com.frozen.rpccommon.proxy.ProxyManager;
import com.frozen.rpccommon.res.BaseResponse;
import com.frozen.rpcserverapi.ISendMsgServerApi;
import com.frozen.rpcserverapi.vo.req.SendMsgReqVO;
import com.frozen.rpcserverapi.vo.res.SendMsgResVO;
import com.sun.org.apache.regexp.internal.RE;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Frozen
 * @create: 2020-04-29 14:29
 * @description:
 **/
@Service
public class ClientApiService {

	@Autowired
	private OkHttpClient okHttpClient;

	public BaseResponse sendMsg(String msg){
		try {
			ISendMsgServerApi sendMsgServerApi = new ProxyManager<>(ISendMsgServerApi.class, "http://localhost:8080", okHttpClient).getInstance();
			SendMsgReqVO sendMsgReqVO = new SendMsgReqVO(1L,msg);
			return sendMsgServerApi.sendMsg(sendMsgReqVO );
		}catch (Exception e){
			return BaseResponse.createFail();
		}
	}
}
