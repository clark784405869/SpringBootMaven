package com.artiope.springbootmaven.controller;

import javax.annotation.Resource;

import com.artiope.springbootmaven.entity.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artiope.springbootmaven.service.DemoService;
import com.artiope.springbootmaven.service.HelloService2;

/**
 * 测试.
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	 @Resource
	 private DemoService demoService;
	 @Resource
	 private HelloService2 helloService2;
	 @Resource
	 private HelloService2 helloService22;
	 private Logger logger =  LoggerFactory.getLogger(this.getClass());
    /**
     * 返回demo数据:
     * 请求地址：http://127.0.0.1:8080/demo/getDemo
     * @return
     */
    @RequestMapping("/getDemo")
    public Demo getDemo(){
       Demo demo = new Demo();
       demo.setId(1);
       demo.setName("zhangpeng");
       logger.info(demo.getId()+":"+demo.getName()+":"+demo.getRemark());
       return demo;
    }
    
    /**
     * 测试保存数据方法.
     * @return
     */
    @RequestMapping("/save")
    public String save(){
       Demo d = new Demo();
       d.setName("zhangpengBaby");
       d.setRemark("测试666");
       demoService.save(d);//保存数据.
       return"ok.Demo2Controller.save";
    }
    
/**
 * 测试查询数据方法
 * @return
 */
    //地址：http://127.0.0.1:8080/demo2/getById?id=1
    @RequestMapping("/getById")
    public Demo getById(long id){
    	System.out.println(id);
       return demoService.getById(id);
    }
    /**
     * http://127.0.0.1:8080/demo2/getTestString
     * @param id
     * @return
     */
    @RequestMapping(value="/getTestString", method = RequestMethod.POST)
    public String getTestString(long id){
    	//System.out.println(id); 
    	//System.out.println(helloService22.getTeString());
    	//System.out.println(helloService2.equals(helloService22));
       return String.valueOf(id);
    }
    
   
 }