package com.java.Dao;


import com.java.Bean.RegistrationBean;

public interface EditProfileDAO {
	public void editProfile(RegistrationBean editBean,String username);
	public RegistrationBean retreiveDetails(String username);
}
