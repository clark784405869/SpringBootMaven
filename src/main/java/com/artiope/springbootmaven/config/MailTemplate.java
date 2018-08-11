package com.artiope.springbootmaven.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
/**
 * 邮件模板bean配置
 * @author zhangpeng_tom@tom.com
 *
 */
@Configuration
@EnableConfigurationProperties(FreeMarkerProperties.class)
public class MailTemplate {
	
	 @Autowired
	    private FreeMarkerProperties properties;
	 @Bean
	public  FreeMarkerConfigurer freeMarkerConfigurer() {
		  FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		  configurer.setTemplateLoaderPath("classpath:templates");
		  return configurer;
	}
}
