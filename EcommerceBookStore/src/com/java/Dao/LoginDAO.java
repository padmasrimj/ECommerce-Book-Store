package com.java.Dao;

import java.util.List;

import com.java.Bean.User;


public interface LoginDAO {
public User retreiveDetails(String username,String password,String verified);
}
