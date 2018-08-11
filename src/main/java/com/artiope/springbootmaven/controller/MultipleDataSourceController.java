package com.artiope.springbootmaven.controller;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artiope.springbootmaven.entity.Demo;
import com.artiope.springbootmaven.service.TestService;

@RestController
public class MultipleDataSourceController {
   
    @Resource
    private TestService testService;
   
    @RequestMapping("/dataSource")
    public String test(){
	    for(Demo d:testService.getList()){
	        System.out.println(d);
	    }
       /*for(Demo d:testService.getListByDs1()){
           System.out.println(d);
       }*/
       return"ok";
    }
    
    @RequestMapping("/datasource1")
    public String test1(){
//     for(Demo d:testService.getList()){
//         System.out.println(d);
//     }
       for(Demo d:testService.getListByDs1()){
           System.out.println(d);
       }
       return"ok";
    }
   
}
