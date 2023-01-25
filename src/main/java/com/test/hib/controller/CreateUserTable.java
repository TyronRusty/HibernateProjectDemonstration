package com.test.hib.controller;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.perscholas.mavenlabs.models.User;


public class CreateUserTable {

	private static ServiceRegistry registry;
	private static SessionFactory factory;
	
public static void main(String[] args) {
  	/*try {
		
		// configuration
			Configuration conf = new Configuration().
					configure(new File
							("src/main/java/org/perscholas/mavenlabs/hibernate.cfg.xml"));
		conf.addAnnotatedClass(User.class);
		//conf.addAnnotatedClass(Department.class);
		// registry
		registry = new StandardServiceRegistryBuilder()
				.applySettings(conf.getProperties())
				.build();
		
		factory = conf.buildSessionFactory(registry);
		
		
	} catch (Throwable ex) {
		ex.printStackTrace();
	
	}*/
	
  	
}
}