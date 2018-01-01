package com.java.Dao;

import com.java.Bean.RegistrationBean;

public interface RegistrationDAO {
	public void saveUser(RegistrationBean regBean);
	public int getCardIdByUserName(String username);
}
