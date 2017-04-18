package com.weixin.validation.app.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.weixin.validation.util.HttpInvokeMethod;
import com.weixin.validation.util.WeiXinApiInvokeUtil;
import com.weixin.validation.util.WeiXinConstant;

/**
 * 刷新 access_token 调度任务类
 */
@Service
public class RefreshAccessTokenScheduledTask {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	//测试每五秒执行一次该方法，系统启动后延迟3秒执行第一次
	//@Scheduled(fixedDelay=5000,initialDelay=3000)
	public void reportCurrentTime(){
		System.out.println(Thread.currentThread().getName() + "--->每隔五秒执行一次 " + dateFormat.format(new Date()));
	}
	
	//7000秒执行一次刷新access_token，大约117分钟。程序启动后立即执行第一次
	@Scheduled(fixedDelay=7000000)
	public void refresh() {
		WeiXinApiInvokeUtil.invoke(WeiXinConstant.ACCESS_TOKEN_URL, HttpInvokeMethod.Get, null, true);
	}
}
