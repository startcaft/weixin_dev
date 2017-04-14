package com.weixin.validation.app.scheduled;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.validation.util.WeiXinConstant;
import com.weixin.validation.util.WeiXinContext;
import com.weixin.vo.AccessToken;
import com.weixin.vo.ErrorEntity;

/**
 * 刷新 access_token 调度任务类
 */
@Service
public class RefreshAccessTokenScheduledTask {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	//测试每五秒执行一次该方法，系统启动后延迟3秒执行第一次
	@Scheduled(fixedDelay=5000,initialDelay=3000)
	public void reportCurrentTime(){
		System.out.println(Thread.currentThread().getName() + "--->每隔五秒执行一次 " + dateFormat.format(new Date()));
	}
	
	//7000秒执行一次刷新access_token，大约117分钟。程序启动后立即执行第一次
	//@Scheduled(fixedDelay=7000000)
	public void refresh() {
		
		HttpGet get = null;
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			client = HttpClients.createDefault();
			String url = WeiXinConstant.ACCESS_TOKEN_URL;
			url = url.replaceAll("APPID", WeiXinConstant.APPID);
			url = url.replaceAll("APPSECRET", WeiXinConstant.APPSECRET);
			get = new HttpGet(url);
			response = client.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);
				try {
					AccessToken accessToken = mapper.readValue(content, AccessToken.class);
					// 将请求到的access_token保存到WeiXinContext微信上下文中。
					WeiXinContext.setAccessToken(accessToken.getAccess_token());
				} catch (Exception e) {
					ErrorEntity error = mapper.readValue(content, ErrorEntity.class);
					System.out.println(error.getErrcode() + "，" + error.getErrmsg());
					// 发生异常，重新请求
					refresh();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
}
