package com.bankaccountmanagementsystem.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bankaccountmanagementsystem.entity.Account;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	

	    static {
	        try {
	            sessionFactory = new Configuration().configure("hibernate1.cfg.xml")
	                    .addAnnotatedClass(Account.class).buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    
}
}