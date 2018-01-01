package com.java.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.Bean.RegistrationBean;
import com.java.Dao.EditProfileDAO;
import com.java.Dao.SessionUtilHibernate;

public class EditProfileDAOImpl implements EditProfileDAO {

	public void editProfile(RegistrationBean editBean,String username) {
		
		Session session = SessionUtilHibernate.getSession();
		Transaction tx = session.beginTransaction();
		RegistrationBean bean = session.get(RegistrationBean.class,username);
		
		bean.setName(editBean.getName());
		bean.setAddress(editBean.getAddress());
		bean.setCity(editBean.getCity());
		bean.setZip(editBean.getZip());
		bean.setState(editBean.getState());
		bean.setEmail(editBean.getEmail());
		bean.setPhoneNumber(editBean.getPhoneNumber());
		
		session.saveOrUpdate(bean);
		
	    session.flush();
	    tx.commit();
	}


	public RegistrationBean retreiveDetails(String username) {
		Session session = SessionUtilHibernate.getSession();
		RegistrationBean bean = session.get(RegistrationBean.class,username);
		return bean;
	}

}
