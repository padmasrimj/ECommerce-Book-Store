package com.java.Service;

import java.io.IOException;

import com.java.Bean.User;

public interface LoginService {

	public User validate(String username,String password) throws IOException;
}
