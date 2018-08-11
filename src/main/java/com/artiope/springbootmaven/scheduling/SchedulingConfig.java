package com.artiope.springbootmaven.scheduling;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
 
/**
 * 定时任务
 * @author Administrator
 *
 */
@Configuration
//@EnableScheduling
public class SchedulingConfig {
	public final static long ONE_Minute =  60 * 1000;
    /*@Scheduled(cron = "0 * 0/2 * * * ") // 每20秒执行一次
    public void scheduler() {
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }*/
//	@Scheduled(fixedDelay=ONE_Minute)
//    public void fixedDelayJob(){
//        System.out.println(" >>fixedDelay执行....");
//    }
//
//    @Scheduled(fixedRate=ONE_Minute)
//    public void fixedRateJob(){
//        System.out.println(" >>fixedRate执行....");
//    }
	//@Scheduled(cron="0 */2 * * * *")
/*
    public void cronJob(){
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
        System.out.println(simpleDateFormat.format(new Date())+" >>cron执行....");
    }*/
}