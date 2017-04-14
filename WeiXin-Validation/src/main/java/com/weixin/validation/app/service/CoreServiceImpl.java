package com.weixin.validation.app.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.weixin.messagehandler.BaseWeiXinMessageHandler;
import com.weixin.messagehandler.SingleNewsMessageHandler;


@Service
public class CoreServiceImpl implements CoreService {
	
	private BaseWeiXinMessageHandler messageHandler;
	
	//初始化
	public CoreServiceImpl() {
		messageHandler = new SingleNewsMessageHandler();
	}

	@Override
	public String WeiXinMessageProcess(HttpServletRequest request) {
		{
			return messageHandler.processRequestTemplate(request);
		}
	}
}
