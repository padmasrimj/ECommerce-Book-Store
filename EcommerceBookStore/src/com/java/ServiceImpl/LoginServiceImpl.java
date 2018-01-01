package com.java.ServiceImpl;
import java.io.IOException;
import java.util.List;

import com.java.Bean.User;
import com.java.DaoImpl.LoginDAOImpl;
import com.java.Service.*;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class LoginServiceImpl implements LoginService{
	private MemcachedClient m_Client;
	@Override
	public User validate(String username,String password) throws IOException {
		LoginDAOImpl logindao = new LoginDAOImpl();
			this.m_Client = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
			String pwd = (String) this.m_Client.get(username);
			User result = null;
			String verified = "";
			if(pwd!= null && pwd.equals(password)) {
				verified = "true";
				System.out.println("Cache hit");
				System.out.println("Valid User");
				result = logindao.retreiveDetails(username,password,verified);	
			}
			if(pwd == null){
				verified = "false";
			System.out.println("Cache miss and adding the value");
			this.m_Client.add(username, 2300, password);
			result = logindao.retreiveDetails(username,password,verified);
			}
		 
			this.m_Client.shutdown();
			return result;

		}
	}

	

