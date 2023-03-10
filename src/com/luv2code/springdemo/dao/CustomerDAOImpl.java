package com.luv2code.springdemo.dao;

import java.util.List;

 
 
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
 
@Repository
public class CustomerDAOImpl  implements CustomerDAO{
	// need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory; 
	
	
	@Override
	public List<Customer> getCustomers() {
		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query 
		 Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName" , Customer.class);
		// execute queary and get resulit list 
		List<Customer> customers = theQuery.getResultList();
		// return the tresult 
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		 // get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer ... finally LoL
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int id) {
		 // get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, id) ;
		return customer ; 
	}


	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*Query theQuery  = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		
		theQuery.executeUpdate();*/
		
		Customer customer = getCustomer(theId);
		
		currentSession.delete(customer);
		
	}
	
	

}
