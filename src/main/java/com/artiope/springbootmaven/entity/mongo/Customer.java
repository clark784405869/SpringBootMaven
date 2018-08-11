package com.artiope.springbootmaven.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//指定对应于集合customer
@Document(collection = "customer")
public class Customer {
//主键
  @Id
  private String _id;
  private String name;
  private String phone;
  private String gender;
  private String birthday;
  private String passport;
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getPassport() {
	return passport;
}
public void setPassport(String passport) {
	this.passport = passport;
}
@Override
public String toString() {
	return "Customer [_id=" + _id + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", birthday="
			+ birthday + ", passport=" + passport + "]";
}
  

}
