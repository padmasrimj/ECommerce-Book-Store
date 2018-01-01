package com.java.Service;
import java.io.IOException;

import com.java.Bean.RegistrationBean;
import com.java.DaoImpl.*;
public interface RegistrationService {
	public boolean registerUser(RegistrationBean regBean,String username)throws IOException ;
	public int getCardIdByUsername(String username);
}
