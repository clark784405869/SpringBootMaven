package com.artiope.springbootmaven.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

import com.artiope.springbootmaven.service.impl.ShanhyA;
import com.artiope.springbootmaven.service.impl.ShanhyB;

/**
 * 实现自己实例化bean并注册为Spring管理
 * org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor 
 * 它的postProcessBeanDefinitionRegistry 和 postProcessBeanFactory 方法是第二和第三被调用，
 * 它们在Bean初始化创建之前启动，如果Spring的bean需要的其他第三方中的组件，我们在这里将其注入给Spring。
 * @author zhangpeng_tom@tom.com
 * @version v.0.1
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	
	//bean 的名称生成器.
	 private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
		
		// 这里可以设置属性，例如
//		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("dataSourceA");
//		MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
//		//加入属性.
////		mutablePropertyValues.addPropertyValue("type", "org.apache.tomcat.jdbc.pool.DataSource");
//		mutablePropertyValues.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//		mutablePropertyValues.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//		mutablePropertyValues.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//		mutablePropertyValues.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");
//		mutablePropertyValues.addPropertyValue("username", "root");
//		mutablePropertyValues.addPropertyValue("password", "123456");
		
	}

	/**
	 * 先执行：postProcessBeanDefinitionRegistry()方法，注册bean
	 * 在执行：postProcessBeanFactory()方法，设置bean属性。
	 * 
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
		
		/*
		 * 在这里可以注入bean.
		 */
		registerBean(registry, "shanhyA", ShanhyA.class);
		registerBean(registry, "shanhyB", ShanhyB.class);
		//需要引入依赖：spring-boot-starter-data-jpa
//		registerBean(registry, "dataSourceA", org.apache.tomcat.jdbc.pool.DataSource.class);
	}
	
	/**
	 * 提供公共的注册方法。
	 * @param beanDefinitionRegistry
	 * @param name
	 * @param beanClass
	 */
	private void registerBean(BeanDefinitionRegistry registry,String name,Class<?> beanClass){
		AnnotatedBeanDefinition annotatedBeanDefinition  = new AnnotatedGenericBeanDefinition(beanClass);
		  //可以自动生成name
		String beanName = (name != null?name:this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
		//bean注册的holer类.
		BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
		//使用bean注册工具类进行注册.
		BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
	}
	
}
