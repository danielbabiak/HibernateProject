package main.java.pl;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerReader {

	private Customer findCustomerById(Long customerID, SessionFactory factory) {
		Session session = factory.openSession();
		Customer customer = null;
		Transaction tx = null;
		try{
			 tx = session.beginTransaction();
			 Query query = session.createQuery("FROM Customer WHERE id = :customerID ");
			 query.setParameter("customerID", customerID);
			 customer = (Customer)query.getSingleResult();
			 tx.commit();
			 }catch (HibernateException e) {
				 if (tx!=null) tx.rollback();
			 		e.printStackTrace();
			 }finally {
				 session.close();
			 }
		return customer;
	}
	
	public String findFullName(Long customerID, SessionFactory factory) {
		Customer customer = findCustomerById(customerID, factory);
		if (customer != null)
			return customer.getFirstName() + " " + customer.getLastName();
		else
			return null;
	}

	public String checkDiscount(Long customerID, SessionFactory factory) {
		Customer customer = findCustomerById(customerID, factory);

		if (customer.getMoneySpended() >= 5000) {
			return "10%";
		} else if (customer.getMoneySpended() >= 2500) {
			return "5%";
		}
		return "0%";
	}

	public Integer checkVisitCost(Long customerID, Date date, SessionFactory factory) {
		Customer customer = findCustomerById(customerID, factory);
		for (int i = 0; i < customer.listVisit.size(); i++) {
			if (customer.listVisit.get(i).getDate().equals(date))
				return customer.listVisit.get(i).getShoppingCost();
		}
		return -1;
	}
}