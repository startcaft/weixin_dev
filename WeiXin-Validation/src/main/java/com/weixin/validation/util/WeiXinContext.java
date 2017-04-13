package com.weixin.validation.util;

/**
 * 微信上下文类，里面包含一个accessToken属性，保存请求到的access_token唯一接口调用凭据
 */
public class WeiXinContext {
	
	private static String accessToken;

	public static String getAccessToken() {
		return WeiXinContext.accessToken;
	}

	public static void setAccessToken(String accessToken) {
		WeiXinContext.accessToken = accessToken;
	}
}