package com.java.ServiceImpl;

import org.json.JSONArray;
import org.json.JSONObject;

import com.java.Bean.RegistrationBean;
import com.java.Dao.EditProfileDAO;
import com.java.DaoImpl.EditProfileDAOImpl;
import com.java.Service.EditProfileService;

public class EditProfileServiceImpl implements EditProfileService{

	
	public void editProfile(RegistrationBean editBean,String username) {
		EditProfileDAO editDao = new EditProfileDAOImpl();
		editDao.editProfile(editBean,username);
		
	}

	public JSONArray retreiveDetails(String username) {
		EditProfileDAO retDao = new EditProfileDAOImpl();
		RegistrationBean bean = retDao.retreiveDetails(username);
		JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			if(bean != null) {
			jsonObject.put("name", bean.getName());
			jsonObject.put("email", bean.getEmail());
			jsonObject.put("phoneNumber", bean.getPhoneNumber());
			jsonObject.put("city", bean.getCity());
			jsonObject.put("address", bean.getAddress());
			jsonObject.put("zip", bean.getZip());
			jsonObject.put("state", bean.getState());
			jsonArray.put(jsonObject);
			}
		return jsonArray;
	}

}
