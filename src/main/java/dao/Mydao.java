package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class Mydao {

	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction()	;


public void save(Customer customer) {
	transaction.begin();
	manager.persist(customer);
    transaction.commit();
}


public Customer featchByEmail(String mail) {
	 List<Customer> list = manager.createQuery("select x from Customer x where email=?1").setParameter(1, mail).getResultList();
	 if(list.isEmpty())
	return null;
	 else
		 return list.get(0);
	 
}
public Customer featchByMobile(long mobile) {
	 List<Customer> list = manager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile).getResultList();
	 if(list.isEmpty())
	return null;
	 else
		 return list.get(0);
	 
}
}
