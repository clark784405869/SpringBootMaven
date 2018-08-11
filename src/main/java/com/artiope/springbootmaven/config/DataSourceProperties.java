package com.artiope.springbootmaven.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
//读取application.properties文件中定义的配置信息
@ConfigurationProperties(prefix = "spring.data.datasource")
//读取自定义的properties文件中定义的配置信息
//@ConfigurationProperties(prefix = "springboottest",locations = "classpath:config/springboottest.properties")  
public class DataSourceProperties {

	 
	    private String host;
	    //private int port = DBPort.PORT;
	    private String uri = "mongodb://localhost/test";
	    private String database;
	    private String type="com.alibaba.druid.pool.DruidDataSource";
	    private String driverClassName="com.mysql.jdbc.Driver111";
	    private String url;
	    private String username;
	    private String password;
	    // ... getters/ setters omitted
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public String getDatabase() {
			return database;
		}
		public void setDatabase(String database) {
			this.database = database;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
	
}
