package com.artiope.springbootTest.service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


public class RestAPITest {
	  private final static String url = "http://127.0.0.1:8088/spring-boot-test/demo/getTestString";
      public String test() {
    	  RestTemplate restTemplate = new RestTemplate();
		String reString = restTemplate.postForObject("http://127.0.0.1:8088/spring-boot-test/demo/getTestString?id=1", new LinkedMultiValueMap<>(), String.class);
		System.out.println("响应结果："+reString);
		return reString;
	}
      
      public static void main(String[] args) {
		  WorkThread w1 =new WorkThread(url, "1");
		  WorkThread w2 =new WorkThread(url, "2");
		  WorkThread w3 =new WorkThread(url, "3");
		  /*Thread t1 = new Thread(w1);
		  Thread t2 = new Thread(w2);
		  Thread t3 = new Thread(w3);
		  t1.start();
		  t2.start();
		  t3.start();*/
		  w1.start();
		  w2.start();
		  w3.start();

	}
}
