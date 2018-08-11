package com.artiope.springbootmaven.entity.mongo;

import org.springframework.data.annotation.Id;
/**
 * mongo实体类
 * @author zhangpeng_tom@tom.com
 *
 */
public class User {
	@Id
     private String id;
     private String name;
     private String pwd;
     private String sex;
     private String salary;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", salary=" + salary + "]";
	}
	
     
     
}
