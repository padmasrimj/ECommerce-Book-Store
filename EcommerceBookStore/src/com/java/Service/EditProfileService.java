package com.java.Service;

import org.json.JSONArray;

import com.java.Bean.RegistrationBean;

public interface EditProfileService {
 public void editProfile(RegistrationBean editBean,String username);
 public JSONArray retreiveDetails(String username);
}
