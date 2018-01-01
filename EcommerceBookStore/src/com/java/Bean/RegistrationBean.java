package com.java.Bean;

import javax.persistence.*;

@Entity
@Table(name="REGISTER")
public class RegistrationBean {
	
@Id
@Column(name="USERNAME", nullable=false)
private String username;

@Column(name="NAME",nullable=false)
private String name;

@Column(name="ADDRESS",nullable=false)
private String address;

@Column(name="CITY",nullable=false)
private String city ;

@Column(name="ZIP",nullable=false)
private String zip ;

@Column(name="STATE",nullable=false)
private String state ;

@Column(name="EMAIL",nullable=false)
private String email ;

@Column(name="PHNO",nullable=false)
private String phoneNumber;

@Column(name="PASSWORD",nullable=false)
private String password;

@GeneratedValue
@Column(name="Cart_ID",nullable = false)
private int cartId;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getCartId() {
    return cartId;
}



}
