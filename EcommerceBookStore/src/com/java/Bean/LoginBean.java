package com.java.Bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class LoginBean {

@Id
@Column(name="Name", nullable=false)
private String username;

@Column(name="Password", nullable=false)
private String password;

@Column(name="ip_address", nullable=true)
private String ipAddress;

@Column(name="login_Date", nullable=true)
private String logoutDate;

@Column(name="login_Time", nullable=true)
private String logoutTime;

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
public String getIpAddress() {
	return ipAddress;
}
public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
}
public String getLogoutDate() {
	return logoutDate;
}
public void setLogoutDate(String logoutDate) {
	this.logoutDate = logoutDate;
}
public String getLogoutTime() {
	return logoutTime;
}
public void setLogoutTime(String logoutTime) {
	this.logoutTime = logoutTime;
}

}
