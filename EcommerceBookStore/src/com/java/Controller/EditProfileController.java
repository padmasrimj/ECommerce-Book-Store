package com.java.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.java.Bean.RegistrationBean;
import com.java.Pojo.Username;
import com.java.Service.EditProfileService;
import com.java.ServiceImpl.EditProfileServiceImpl;


@Path("/editServices")
public class EditProfileController {
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)	
	public void editProfile(RegistrationBean editBean) {
        System.out.println("in ; ");
      //  HttpSession session = request.getSession();
        //String username = (String)session.getAttribute("username");
        String username = editBean.getUsername();
		EditProfileService editService = new EditProfileServiceImpl();
		editService.editProfile(editBean,username);
	}
	
	@POST
	@Path("/retreive")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retreiveDetails(Username username){
		//HttpSession session = request.getSession();
        //String username = (String)session.getAttribute("username");
		String user = username.getUsername();
        EditProfileService retService = new EditProfileServiceImpl();
        JSONArray bean = retService.retreiveDetails(user);
        /*return Response.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").status(201)
				.entity(bean.toString()).build();*/
        return Response.ok().entity(bean.toString()).build();
	}
}
