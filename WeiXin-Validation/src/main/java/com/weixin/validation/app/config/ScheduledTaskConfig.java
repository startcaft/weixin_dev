package com.weixin.validation.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * 调度任务配置类
 */
@Configuration
@EnableScheduling
@ComponentScan("com.weixin.validation.app.scheduled")
public class ScheduledTaskConfig {
}
