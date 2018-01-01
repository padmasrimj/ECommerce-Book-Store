package com.java.ServiceImpl;

import com.java.Dao.LogoutDAO;
import com.java.DaoImpl.LogoutDAOImpl;
import com.java.Service.LogoutService;

public class LogoutServiceImpl implements LogoutService {

	public boolean insertDeails(String username) {
	LogoutDAO logout = new LogoutDAOImpl();
	boolean result = logout.insertDetails(username);
	return result;
	}

}
