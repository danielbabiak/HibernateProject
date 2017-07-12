package main.java.pl;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;
	public static void main(String[] args) {
		CustomerReader customerReader = new CustomerReader();
		try{
	      factory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable ex) { 
	      System.err.println("Failed to create sessionFactory object." + ex);
	      throw new ExceptionInInitializerError(ex); 
		}
		
		System.out.println(customerReader.findFullName(1L, factory));
		factory.close();
	}

}