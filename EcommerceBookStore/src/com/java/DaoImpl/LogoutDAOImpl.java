package com.java.DaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.java.Bean.LoginBean;

import com.java.Dao.LogoutDAO;
import com.java.Dao.SessionUtilHibernate;


public class LogoutDAOImpl implements LogoutDAO{

	public boolean insertDetails(String username) {
		try{
		Session session = SessionUtilHibernate.getSession();
		LoginBean bean = session.load(LoginBean.class, username);
		Transaction tx = session.beginTransaction();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dft = new SimpleDateFormat("HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		String reportTime = dft.format(today);
		bean.setLogoutDate(reportDate);
		bean.setLogoutTime(reportTime);
		bean.setIpAddress(getPublicIpAddress());
		session.saveOrUpdate(bean);
		session.flush();
        tx.commit();
        return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	public String getPublicIpAddress() throws MalformedURLException,IOException {

	    URL connection = new URL("http://checkip.amazonaws.com/");
	    URLConnection con = connection.openConnection();
	    String str = null;
	    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    str = reader.readLine();
	    return str;
	}
}
