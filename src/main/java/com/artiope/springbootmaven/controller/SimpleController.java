package com.artiope.springbootmaven.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SimpleController {
	
	    @RequestMapping(value ="/hello", method = RequestMethod.GET)
	   // @ResponseBody
	    public String hello(){
	        return "hello world";
	    }
	    @RequestMapping(value ="/", method = RequestMethod.GET)
	    //@ResponseBody
	    public String hello2(){
	    	throw new IndexOutOfBoundsException();
	       // return "hello peng!";
	    }
}
