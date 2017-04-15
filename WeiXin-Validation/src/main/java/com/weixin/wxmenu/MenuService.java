package com.weixin.wxmenu;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.weixin.validation.util.WeiXinConstant;
import com.weixin.validation.util.WeiXinContext;

public class MenuService {
	
	public void createMenu(String menuJson){
		
		CloseableHttpClient client = null;
		HttpPost post = null;
		CloseableHttpResponse response = null;
		
		try {
			client = HttpClients.createDefault();
			String url = WeiXinConstant.CREATE_MENU_URL;
			url = url.replaceAll("ACCESS_TOKEN", WeiXinContext.getInstance().getAccessToken());
			post = new HttpPost(url);
			//设置post提交
			StringEntity entity = new StringEntity(menuJson, ContentType.create("application/json", "utf-8"));
			post.setEntity(entity);
			
			response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300) {
				//输出微信服务器响应的结果
				String responseJson = EntityUtils.toString(response.getEntity());
				System.out.println(responseJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
}
