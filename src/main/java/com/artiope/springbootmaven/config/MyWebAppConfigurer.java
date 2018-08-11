package com.artiope.springbootmaven.config;

import com.artiope.springbootmaven.interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.artiope.springbootmaven.interceptor.MyInterceptor2;


@Configuration
public class MyWebAppConfigurer extends  WebMvcConfigurerAdapter{

	/**
	 * 自定义静态文件访问路径与服务器文件路径映射，
	 * 可用于屏蔽服务器部署路径信息，避免不必要的攻击
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 访问myres根目录下的fengjing.jpg 的URL为 http://localhost:8080/fengjing.jpg （/** 会覆盖系统默认的配置）
		// registry.addResourceHandler("/**").addResourceLocations("classpath:/myres/").addResourceLocations("classpath:/static/");
				
		//访问地址：http://127.0.0.1:8080/myres/test1.jpg
		registry.addResourceHandler("/mydir/**").addResourceLocations("classpath:/mydir/");
				
		
		//访问地址：http://127.0.0.1:8080/api_files/test1.jpg
		// 可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:
		//registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files/");
		
		super.addResourceHandlers(registry);
	}
	/**
	 * 将自定义的拦截器添加到容器之中，使之生效
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
 
	
}

