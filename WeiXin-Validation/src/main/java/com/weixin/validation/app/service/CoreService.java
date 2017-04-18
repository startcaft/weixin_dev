package com.weixin.validation.app.service;

import javax.servlet.http.HttpServletRequest;
import com.weixin.vo.ErrorEntity;

public interface CoreService {
	
	/**
	 * 处理微信请求消息，并返回响应消息
	 */
	public String WeiXinMessageProcess(String fromUserName, String toUserName);
	
	/**
	 * 创建自定义菜单
	 */
	public ErrorEntity createWeiXinMenu(HttpServletRequest request);
}
