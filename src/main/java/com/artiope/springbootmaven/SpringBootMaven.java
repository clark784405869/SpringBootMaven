package com.artiope.springbootmaven;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 */
@SpringBootApplication
// 使spring能够自动扫描到我们自定义的servlet和filter,也可以通过注册代码的方式
@ServletComponentScan
//使用自定义的properties配置文件
//@EnableConfigurationProperties(MySettings.class,MySettings2.class})  
//指定springboot扫描哪些包
//@ComponentScan(basePackages={"cn.kfit","org.kfit"})
//通过ActiveProfiles指定 类似于在属性文件中配置 --spring.profiles.active=prod
//ActiveProfiles只用在测试类或测试环境中，生产环境一般用属性文件指定，以激活程序中使用@Profile(value)注解声明并满足指定value的bean
//@ActiveProfiles("dev")
public class SpringBootMaven  extends SpringBootServletInitializer{
 
   
 
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}

	public static void main(String[] args) {
    	//通过设置环境变量的方式设置热部署自动重启服务的功能的其用于关闭
        //System.setProperty("spring.devtools.restart.enabled","false");
    	
        SpringApplication.run(SpringBootMaven.class, args);
    }
}