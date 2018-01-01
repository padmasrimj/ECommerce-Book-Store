package com.java.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
	 
public class SessionUtilHibernate {    
    private static SessionUtilHibernate instance = null; 
    private SessionFactory sessionFactory;

    private SessionUtilHibernate(){
        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");         
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionUtilHibernate getInstance(){
    		if (instance == null){
    			instance = new SessionUtilHibernate();
    		}
            return instance;
    }
    

    public static Session getSession(){
    	Session session =  getInstance().sessionFactory.openSession();
    	return session;
    }
}
