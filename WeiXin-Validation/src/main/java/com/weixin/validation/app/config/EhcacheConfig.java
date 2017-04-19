package com.weixin.validation.app.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/*ehcache配置*/
@Configuration
@EnableCaching//开启Spring注解式缓存的支持
public class EhcacheConfig {
	
	/*
	 * 配置EhcacheMnaager
	 */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
		{
			System.out.println("CacheConfiguration.ehCacheCacheManager()");
		}
		{
			return new EhCacheCacheManager(bean.getObject());
		}
	}
	
	/*
	 * EhCacheManagerFactoryBean：Spring提供的创建EhCacheManager的工厂类
	 * 主要配置 ehcache.xml配置文件的位置，以及是否可以共享CacheManager，这个决定了创建EhCacheManager的方式（很重要）
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
		{
			System.out.println("CacheConfiguration.ehCacheManagerFactoryBean()");
		}
		{
			EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
			cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
			cacheManagerFactoryBean.setShared(true);
			return cacheManagerFactoryBean;
		}
	}
}
