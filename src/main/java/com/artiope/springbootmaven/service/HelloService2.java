package com.artiope.springbootmaven.service;


import java.util.Random;

import org.springframework.stereotype.Service;
 
@Service
public class HelloService2 {
   private String teString ;
   private int ras ;
    /**
     * 启动的时候观察控制台是否打印此信息;
     */
    public HelloService2() {
    	Random random = new Random();
    	this.ras = random.nextInt();
       System.out.println("HelloService2.HelloService2()");
       System.out.println("HelloService2.HelloService2()");
       System.out.println("HelloService2.HelloService2()");
    }
	public String getTeString() {
		return teString+"test"+ras;
	}
	public void setTeString(String teString) {
		this.teString = teString;
	}
	public int getRas() {
		return ras;
	}
	public void setRas(int ras) {
		this.ras = ras;
	}
}

