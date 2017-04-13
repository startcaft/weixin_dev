package com.weixin.validation.util;

public class WeiXinConstant {
	
	/**配置微信公众号时填写的token参数**/
	public final static String TOKEN = "startcaft";
	
	/**应用ID**/
	public final static String APPID = "wx898bf299e87c9656";
	
	/**应用密钥**/
	public final static String APPSECRET = "359f181504949525bdb4775d18fb4d1d";
	
	/**请求access_token(微信全局唯一的接口调用凭据)的url地址，使用的时候将字【符串中的APPID】替换成本类【常量APPID】，将【字符串APPSECRET】替换成本类【常量APPSECRET】**/
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**获知微信服务器的IP地址列表的url地址，使用的时候将【字符串ACCESS_TOKEN】替换成【AccessToken类的access_token属性】**/
	public final static String SERVER_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
}
