package com.artiope.springbootmaven.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
/**
 * 服务初始化完成，服务启动前，可以用于执行加载数据等服务启动前服务提供者自定义的预处理操作
 *
 * @author   Angel
 */
@Component
//@Order(value=2)
public class MyStartupRunner1 implements CommandLineRunner {
 
    @Override
    public void run(String... args) throws Exception {
    	
    	
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作111111111<<<<<<<<<<<<<");
    }
 
}
