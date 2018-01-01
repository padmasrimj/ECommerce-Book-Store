package com.java.DaoImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.java.Bean.LoginBean;
import com.java.Bean.User;
import com.java.Dao.*;

public class LoginDAOImpl implements LoginDAO {

	@SuppressWarnings("unchecked")
	@Override
	public User retreiveDetails(String username,String password,String verified) {
		
		Session session = SessionUtilHibernate.getSession();
		if(verified.equals("false")) {
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userName",username ));
		cr.add(Restrictions.eq("password",password ));
		List<User> results = cr.list();
		if(!results.isEmpty() && results.size() == 1) {
			return results.get(0);
		} else {
			return null;
		}
		}
		else {
			User bean = session.load(User.class, username);
			return bean;
		}
	}
}
