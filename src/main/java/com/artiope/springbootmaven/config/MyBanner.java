package com.artiope.springbootmaven.config;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

/**
 * banner接口的实现类用于自定义控制台的输出项，也可以使用在classpath下创建banner.txt文件的方式指定输出项
 * @author zhangpeng_tom@tom.com
 *
 */
public class MyBanner implements Banner {

	@Override
	public void printBanner(Environment arg0, Class<?> arg1, PrintStream arg2) {
		// TODO Auto-generated method stub
		
	}
	

}
