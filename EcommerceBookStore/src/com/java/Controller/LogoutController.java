package com.java.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.java.Bean.LoginBean;
import com.java.Service.LogoutService;
import com.java.ServiceImpl.LoginServiceImpl;
import com.java.ServiceImpl.LogoutServiceImpl;

@Path("/logoutservices")
public class LogoutController {
		@Path("/logout")
		@POST
		@Consumes("application/json")
		@Produces("application/json")
		public Response isValidUser(LoginBean login, @Context HttpServletRequest request) {
			String userName = login.getUsername();
			LogoutService logout = new LogoutServiceImpl();
			boolean result  = logout.insertDeails(userName);
			JSONObject username = new JSONObject();
			if(result) {
			username.put("validate", "true");
			} else {
				username.put("validate", false);
			}
			return Response.ok().entity(String.valueOf(username)).build();
		}
		

}
