package com.artiope.springbootTest.service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class WorkThread extends Thread{
  
	
	private String url ;
	private String tid ;
	public WorkThread(String url,String id) {
		super();
      this.url = url;
      this.tid = id;
	}

	@Override
	public void run() {
		 RestTemplate restTemplate = new RestTemplate();
			String reString = restTemplate.postForObject(url+"?id="+tid, new LinkedMultiValueMap<>(), String.class);
			System.out.println("响应结果："+reString);
			
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String gettId() {
		return tid;
	}

	public void settId(String id) {
		this.tid = id;
	}

}
