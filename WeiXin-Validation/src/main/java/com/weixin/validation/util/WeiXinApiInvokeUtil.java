package com.weixin.validation.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.vo.AccessToken;
import com.weixin.vo.ErrorEntity;

/**
 * 微信API调用工具类
 */
public class WeiXinApiInvokeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(WeiXinApiInvokeUtil.class);
	
	/**
	 * API调用方法
	 * @param apiUrl	要调用的API地址
	 * @param method	http方法
	 * @param postData	post的数据
	 * @param isAccessToken 是否获取AccessToken，它的处理方式不一样
	 * @return ErrorEntity 只要ErrorEntity中的属性errcode为0，就表示调用成功，否则调用失败
	 */
	public static ErrorEntity invoke(String apiUrl,HttpInvokeMethod method,String postData,boolean isAccessToken){
		{
			ErrorEntity error = new ErrorEntity();
			error.setErrcode("9999");
			
			CloseableHttpClient client = null;//HttpClient默认实现
			HttpPost post = null;
			HttpGet get = null;
			CloseableHttpResponse response = null;//HttpResponse默认实现
			ObjectMapper mapper = new ObjectMapper();
			
			if (StringUtils.isEmpty(apiUrl)) {
				error.setErrmsg("api地址不能为空");
			}
			else{
				try {
					client = HttpClients.createDefault();
					if (apiUrl.contains("APPID")) {
						apiUrl = apiUrl.replaceAll("APPID", WeiXinConstant.APPID);
					}
					if (apiUrl.contains("APPSECRET")) {
						apiUrl = apiUrl.replaceAll("APPSECRET", WeiXinConstant.APPSECRET);
					}
					if (apiUrl.contains("ACCESS_TOKEN")) {
						apiUrl = apiUrl.replaceAll("ACCESS_TOKEN", WeiXinContext.getInstance().getAccessToken());
					}
					int statusCode;
					switch (method) {
						case Get:
							get = new HttpGet(apiUrl);
							response = client.execute(get);
							break;
						case Post:
							post = new HttpPost(apiUrl);
							StringEntity entity = new StringEntity(postData, ContentType.create("application/json", "utf-8"));
							post.setEntity(entity);
							response = client.execute(post);
							break;
						default:
							error.setErrmsg("未知的http谓词");
							break;
					}
					statusCode = response.getStatusLine().getStatusCode();
					if (statusCode >= 200 && statusCode < 300) {
						//如果是获取access_token的调用，那么处理方式不一样，正确是返回{"access_token":"ACCESS_TOKEN","expires_in":7200}，封装成AccessToken对象，
						//并保存到WeiXinContext对象中。
						//错误则返回{"errcode":40013,"errmsg":"invalid appid"}，然后开启又一轮的调用。
						if (isAccessToken) {
							HttpEntity entity = response.getEntity();
							String content = EntityUtils.toString(entity);
							try {
								AccessToken accessToken = mapper.readValue(content, AccessToken.class);
								WeiXinContext.getInstance().setAccessToken(accessToken.getAccess_token());
							} catch (Exception e) {
								error = mapper.readValue(content, ErrorEntity.class);
								if (logger.isDebugEnabled()) {
									logger.debug("刷新access_token失败。" + error.getErrcode() + "，" + error.getErrmsg());
									logger.debug("马上开始一次新的刷新");
									invoke(apiUrl, HttpInvokeMethod.Get, null, true);
								}
							}
						}
						//如果是其他的api调用，则统一返回{"errcode":40013,"errmsg":"invalid appid"}，errcode为0则是调用成功
						else{
							String responseJson = EntityUtils.toString(response.getEntity());
							error = mapper.readValue(responseJson, ErrorEntity.class);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {//释放资源
					if (response != null) {
						try {
							response.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (client != null) {
						try {
							client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			return error;
		}
	}
}
