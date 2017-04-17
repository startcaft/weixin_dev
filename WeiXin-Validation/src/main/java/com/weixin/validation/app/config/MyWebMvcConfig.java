package com.weixin.validation.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * 保留SpringBoot的MVC特性，加入自定义配置
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
		
	/*jsp配置视图解析器*/
	@Bean
	public InternalResourceViewResolver viewResolver(){
		{
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			viewResolver.setViewClass(JstlView.class);
			return viewResolver;
		}
	}
	
	/*静态资源处理*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	/*配置快捷的ViewController，只是页面跳转的Controller*/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	}
	
	/*接受路径参数中的. ，/a/b/c.d*/
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
}
