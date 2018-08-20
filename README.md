# SpringBootMaven
本项目为使用Maven构建SpringBoot微服务的顶级项目源码

1、项目基础代码功能：
   基础Package结构：
   基础代码：基本MVC结构
     控制层：
     服务层：
     视图层：目前支持Freemarker及Thymeleaf两种模板引擎，后续将引入AugularJs，并进行分版，提供多种前端支持
     持久化层：支持两种形式的jpa，提供基础Repostitory层代码实现
   基础配置：
     
   基础工具类：
     JacksonUtil:json处理工具类
     DateUtil：常见日期格处理工具类
     SpringUtil：手工获取调用Spring bean对象的工具类
1、整合阿里druid数据库连接池：
    Druid简介：
      Druid 是目前比较流行的高性能的，分布式列存储的OLAP框架(具体来说是MOLAP)。它有如下几个特点：
      一. 亚秒级查询
           druid提供了快速的聚合能力以及亚秒级的OLAP查询能力，多租户的设计，是面向用户分析应用的理想方式。
      二.实时数据注入
           druid支持流数据的注入，并提供了数据的事件驱动，保证在实时和离线环境下事件的实效性和统一性
      三.可扩展的PB级存储
           druid集群可以很方便的扩容到PB的数据量，每秒百万级别的数据注入。即便在加大数据规模的情况下，也能保证时其效性
      四.多环境部署
           druid既可以运行在商业的硬件上，也可以运行在云上。它可以从多种数据系统中注入数据，包括hadoop，spark，kafka，storm和samza等
      五.丰富的社区
           druid拥有丰富的社区，供大家学习。
     相关依赖：
     <dependency>
		    <groupId>com.alibaba</groupId>
		    <artifactId>druid</artifactId>
		    <version>${druid.version}</version>
	    </dependency>
      
2、动态数据源:
    
3、全局异常处理:
      try..catch..finally 再也不见踪影！
4、系统日志（LogBack）:
     Spring boot内部使用Commons Logging来记录日志，但也保留外部接口可以让一些日志框架来进行实现，例如Java Util Logging,Log4J2还有Logback。支持根据实际需求引入日志框架并进行相关配置，默认情况下，spring boot使用Logback作为日志实现的框架。
   <dependency> 
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-mail</artifactId>
	</dependency>   
5、邮件发送:
   针对注册验证，忘记密码或者是给用户发送营销信息，应该是网站的必备拓展功能之一，传统Spring项目中我们一般使用JavaMail相关api来开发有关邮件的相关代码，SpringBoot针对邮件发送提供了一套更简易使用的封装。
 
6、Actuator健康检查:
Spring Boot 的 Actuator 提供了很多生产级的特性，比如监控和度量Spring Boot 应用程序。Actuator 的这些特性可以通过众多 REST 接口、远程 shell 和 JMX 获得。

6.1、Actuator 的 REST 接口
    Spring Boot Actuator 的关键特性是在应用程序里提供众多 Web 接口，通过它们了解应用程序运行时的内部状况。Actuator 提供了 13 个接口，可以分为三大类：配置接口、度量接口和其它接口，具体如下表所示。

6.2  HTTP 方法	路径	描述
    GET	/autoconfig	提供了一份自动配置报告，记录哪些自动配置条件通过了，哪些没通过
    GET	/configprops	描述配置属性(包含默认值)如何注入Bean
    GET	/beans	描述应用程序上下文里全部的Bean，以及它们的关系
    GET	/dump	获取线程活动的快照
    GET	/env	获取全部环境属性
    GET	/env/{name}	根据名称获取特定的环境属性值
    GET	/health	报告应用程序的健康指标，这些值由HealthIndicator的实现类提供
    GET	/info	获取应用程序的定制信息，这些信息由info打头的属性提供
    GET	/mappings	描述全部的URI路径，以及它们和控制器(包含Actuator端点)的映射关系
    GET	/metrics	报告各种应用程序度量信息，比如内存用量和HTTP请求计数
    GET	/metrics/{name}	报告指定名称的应用程序度量值
    POST	/shutdown	关闭应用程序，要求endpoints.shutdown.enabled设置为true
    GET	/trace	提供基本的HTTP请求跟踪信息(时间戳、HTTP头等)
7、集成Spring-boot-starter-data-jpa：
    Spring-boot-starter-data-jpa 是Spring Data系列的一部分，可以轻松实现基于JPA的数据持久化操作，旨在通过提供通用接口减少持久层的编码量，提高代码质量，降低代码和SQL的维护成本，避免SQL注入等安全风险。作为开发人员只需编写Repostitory接口，Spring将自动提供实现数据库读写
   相关依赖：
   <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
       </dependency>
