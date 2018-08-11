package com.artiope.springbootmaven.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
/**
 * 服务启动执行
 *
 * @author   zhangpeng_tom@tom.com
 */
@Component
@Order(value=1)
public class MyStartupRunner2 implements CommandLineRunner {
 
    @Override
    public void run(String... args) throws Exception {
    	 System.out.println(Arrays.asList(args));
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 22222222 <<<<<<<<<<<<<");
    }
 
}
