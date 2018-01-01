package com.java.Controller;


import java.io.IOException;

import javax.ws.rs.Consumes;
import com.java.ServiceImpl.LoginServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
 
@Path("/loginold")
public class LoginServices {
	@Path("/loginservices")
	@POST
	public void isValidUser(MultivaluedMap<String, String> formParam) {
        System.out.println("in controller");
		String userName = formParam.getFirst("username");
		String password = formParam.getFirst("password");
		LoginServiceImpl service = new LoginServiceImpl();
		try {
			service.validate(userName,password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
