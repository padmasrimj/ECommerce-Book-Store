package com.java.Controller;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.java.Bean.RegistrationBean;
import com.java.Service.*;
import com.java.ServiceImpl.RegistrationServiceImpl;
import com.sun.jersey.api.view.Viewable;

@Path("/customer")
public class CartController {

    private RegistrationService registerService = new RegistrationServiceImpl();
    
    
    @Path("/getcartId/{uname}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCart(@Context HttpServletRequest request, @PathParam("uname") String uname){
    	System.out.println("Getting cart Id for username"+uname);
    	int cartId = registerService.getCardIdByUsername(uname);
    	return Integer.toString(cartId);
    }
    /*
    @Path("/{cartId}")
    public Map<String, Object> loginView(@PathParam (value = "cartId") int cartId){
        final Map<String, Object> model = new HashMap<>();
		model.put("cartId", cartId);
		return model;
    }*/
}
