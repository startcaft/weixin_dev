package com.weixin.validation.app.service;

import javax.servlet.http.HttpServletRequest;

public interface CoreService {
	
	/**
	 * 统一处理微信请求消息，并返回响应消息
	 */
	public String WeiXinMessageProcess(HttpServletRequest request);
}
