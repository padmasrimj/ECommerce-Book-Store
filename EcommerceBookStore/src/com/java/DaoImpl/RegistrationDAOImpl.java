package com.java.DaoImpl;

import com.java.Bean.CartBean;
import com.java.Bean.LoginBean;
import com.java.Bean.RegistrationBean;
import com.java.Dao.RegistrationDAO;
import com.java.Dao.SessionUtilHibernate;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegistrationDAOImpl implements RegistrationDAO {
	

	public void saveUser(RegistrationBean regBean) {
		Session session = SessionUtilHibernate.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(regBean.getName());
		session.saveOrUpdate(regBean);
        //Add login details to the usernmae table
		LoginBean bean = new LoginBean();
        bean.setUsername(regBean.getUsername());
        bean.setPassword(regBean.getPassword());
        session.save(bean);
        session.flush();
        tx.commit();
        
        tx = session.beginTransaction();
		
        //Add cart details to the cart table
        CartBean cart = new CartBean();
        cart.setCartId(getCardIdByUserName(regBean.getUsername()));
        session.save(cart);
        session.flush();
        tx.commit();
		
	}
	
	public String getEmailByUserName(String userName){
		System.out.println("inside getEmailDAO");
		String sql = "select email from Register where username= ?";
		Session session = SessionUtilHibernate.getSession();
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, userName);
		List emailId = query.list();	
		return emailId.get(0).toString();
	}
	
	public String getNameByUserName(String userName){
		String sql = "select name from Register where username= ?";
		Session session = SessionUtilHibernate.getSession();
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, userName);
		List name = query.list();
		
		return name.get(0).toString();
	}
	public int getCardIdByUserName(String username){
		Session session = SessionUtilHibernate.getSession();
		String sql = "select Cart_ID from Register where username= ?";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, username);
		List cartID = query.list();
		return Integer.parseInt(cartID.get(0).toString());
	}
}
