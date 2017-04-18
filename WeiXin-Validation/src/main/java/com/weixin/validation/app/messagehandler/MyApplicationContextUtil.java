package com.weixin.validation.app.messagehandler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		MyApplicationContextUtil.context = applicationContext; 
	}
	
	public static Object getBean(Class<?> classes){
		return MyApplicationContextUtil.context.getBean(classes);
	}
}