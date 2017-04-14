package com.weixin.validation.util;

/**
 * 微信上下文类，里面包含一个accessToken属性，保存请求到的access_token唯一接口调用凭据
 */
public class WeiXinContext {
	
	private static WeiXinContext instance = null;
	
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	private WeiXinContext() {}
	
	synchronized public static WeiXinContext getInstance(){
		{
 			if (instance == null) {
 				instance = new WeiXinContext();
			}
 			return instance;
 		}
	}
}