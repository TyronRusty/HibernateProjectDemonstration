package org.perscholas.mavenlabs;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.perscholas.mavenlabs.models.User;

import jakarta.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ServiceRegistry registry;
	private static SessionFactory factory;
	
    public static void main( String[] args )
    {
    	try {
    		
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
    	
    	}
    	Transaction tx = null;
    	Session session0 = factory.openSession();
		try {

			tx = session0.beginTransaction();
			// Creating a User table
			User u = new User();
			tx.commit();
			System.out.println("successfully created user table");
		} catch (HibernateException ex) {

			ex.printStackTrace();
			tx.rollback();

		} finally {
			session0.close();
		}
    	
    	Session session = factory.openSession();
    	try{
    		//creatingUsers
    		tx = session.beginTransaction();
    		// transient mode
   
    		User one = new User( "MohHaseeb", "haseeb@gmail.com" , "has123", 20 ,2000.69, "NYC");
    		User ufour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3,"NJ");
    		User ufive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
    		
    		User uTwo = new User();
    		uTwo.setEmail("James@gmail.com");
    		uTwo.setFullname("James Santana");
    		uTwo.setPassword("James123");
    		uTwo.setSalary(2060.69);
    		uTwo.setAge(25);
    		uTwo.setCity("Dallas");
    		
    		User uThree = new User();
    		uThree.setEmail("Shahparan@gmail.com");
    		uThree.setFullname("AH Shahparan");
    		uThree.setPassword("Shahparan123");
    		uThree.setSalary(3060.69);
    		uThree.setAge(30);
    		uThree.setCity("Chicago");
    		
    		session.persist(one);
    		session.persist(uTwo);
    		session.persist(ufour);
    		session.persist(uThree);
    		session.persist(ufive);
    
    		tx.commit();
    
  
    	} catch (HibernateException ex) {
    		
    		ex.printStackTrace();
    		tx.rollback();
    		
    	} finally {
    		session.close();

    	}
    	Session session1 = factory.openSession();
		try {
			// here I am updating the user 
			tx = session1.beginTransaction();
			User uUpdate = new User();
			uUpdate.setId(1);
			uUpdate.setEmail("mhaseeb@perscholas");
			uUpdate.setFullname("stranger");
			uUpdate.setPassword("123456");
			session1.merge(uUpdate);
    		tx.commit();
    

		} catch (HibernateException ex) {

			ex.printStackTrace();
			tx.rollback();

		} finally {
			session1.close();

		}
    	
		Session session2 = factory.openSession();
		try {
			// finding the user
			tx = session2.beginTransaction();
			int USER_ID = 2;
			User uFind = session2.find(User.class, USER_ID);
			System.out.println("Fullname: " + uFind.getFullname());
			System.out.println("Email: " + uFind.getEmail());
			System.out.println("password: " + uFind.getPassword());
			tx.commit();

		} catch (HibernateException ex) {

			ex.printStackTrace();
			tx.rollback();

		} finally {
			session2.close();

		}
		Session session3 = factory.openSession();
		try {
			// deleting user
			tx = session3.beginTransaction();
			User u = new User();
			u.setId(3);
			session3.remove(u);
			tx.commit();

		} catch (HibernateException ex) {

			ex.printStackTrace();
			tx.rollback();

		} finally {
			session3.close();

		}
    }
}
