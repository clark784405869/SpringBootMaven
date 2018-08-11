package com.artiope.springbootmaven.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在方法上使用，用于指定使用哪个数据源
 * @author zhangpeng_tom@tom.com
 * @version v.0.1
 * Target 用于设定注解使用范围,允许设定一个或多个范围，表示该注解只能在指定的范围内使用，超出将会报错，
 * Retention注解
 * Retention(保留)注解说明,这种类型的注解会被保留到那个阶段. 有三个值:
 *       RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
 *       RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
 *       RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
 *
 *Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,
 *则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中.*
 *
 *
 *
 *
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
