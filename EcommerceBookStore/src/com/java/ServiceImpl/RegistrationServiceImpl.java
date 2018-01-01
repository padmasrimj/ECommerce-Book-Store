
package com.java.ServiceImpl;

import java.io.IOException;

import com.java.Bean.RegistrationBean;
import com.java.Dao.RegistrationDAO;
import com.java.DaoImpl.RegistrationDAOImpl;
import com.java.Service.RegistrationService;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class RegistrationServiceImpl implements RegistrationService {
	private MemcachedClient m_Client;
	
	RegistrationDAO regDao = new RegistrationDAOImpl();
	public boolean registerUser(RegistrationBean regBean,String username) throws IOException {
			this.m_Client = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
	
		String pwd = (String) this.m_Client.get(username);
		if(pwd == null) {
		this.m_Client.add(username, 2330, regBean.getPassword());
		regDao.saveUser(regBean);
		this.m_Client.shutdown();
		return true;
		} else {
			System.out.println("Username already exists");
			this.m_Client.shutdown();
		return false;
		}
	}
	public int getCardIdByUsername(String username) {
		return regDao.getCardIdByUserName(username);
	}

}
