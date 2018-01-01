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
import com.java.Bean.User;
import com.java.ServiceImpl.LoginServiceImpl;

@Path("/loginservices")
public class LoginController {
	@Path("/test")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response isValidUser(LoginBean login, @Context HttpServletRequest request) {
		try {
		String userName = login.getUsername();
		String password = login.getPassword();
		LoginServiceImpl service = new LoginServiceImpl();
		User result = service.validate(userName, password);
		JSONObject username = new JSONObject();
		if (result != null) {
			username.put("logoutDate", result.getLogoutDate());
			username.put("logoutTime", result.getLogoutTime());
			username.put("logoutLocation", result.getIpAddress());
			username.put("username", userName);
			username.put("validate", "true");
		} else {

			username.put("validate", "false");
		}
		return Response.ok().entity(String.valueOf(username)).build();
		} catch(Exception e) {
			return null;
		}
	}

	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		System.out.println("InSide hello");
		return "Hello Jersey";
	}

}
