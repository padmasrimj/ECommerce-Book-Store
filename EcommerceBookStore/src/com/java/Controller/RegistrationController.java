package com.java.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.java.Bean.RegistrationBean;
import com.java.Service.RegistrationService;
import com.java.ServiceImpl.RegistrationServiceImpl;;

@Path("/registrationServices")
public class RegistrationController {
	@Path("/register")
	@POST
	@Consumes("application/json")	
	public Response registerUser(RegistrationBean regBean) {
		try{
		String username = regBean.getUsername();
		RegistrationService regService = new RegistrationServiceImpl();
		boolean result = regService.registerUser(regBean,username);
		JSONObject data = new JSONObject();
		if(result) {
			data.put("validate","true");
		} else {
			data.put("validate", "false");
		}
		return Response.ok().entity(String.valueOf(data)).build();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
