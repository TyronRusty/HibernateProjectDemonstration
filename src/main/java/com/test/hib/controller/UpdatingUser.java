package com.test.hib.controller;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.perscholas.mavenlabs.models.User;

import jakarta.persistence.TypedQuery;



public class UpdatingUser {


	private static ServiceRegistry registry;
	private static SessionFactory factory;
	public static void main(String[] args) {
	
		try {
			
			// configuration
				Configuration conf = new Configuration().
						configure(new File
								("src/main/java/org/perscholas/mavenlabs/hibernate.cfg.xml"));
	
			conf.addAnnotatedClass(User.class);
			
			registry = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties())
					.build();
			
			factory = conf.buildSessionFactory(registry);
			
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		
		}
		
		Transaction tx = null;
    	Session session = factory.openSession();
    	try{
    		
    		tx = session.beginTransaction();
    		// transient mode
    		//code goes here
    		
  
    	} catch (HibernateException ex) {
    		
    		ex.printStackTrace();
    		tx.rollback();
    		
    	} finally {
    		session.close();

    	}
		
		
		
		}
	
}
