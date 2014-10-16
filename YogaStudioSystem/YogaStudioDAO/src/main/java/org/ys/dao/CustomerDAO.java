package org.ys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Customer;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ICustomerDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerDAO extends GenericHibernateDAO<Customer, Long> implements
		ICustomerDAO {

	public Customer getCustomer(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"FROM Customer c WHERE c.user.username=:uname");
		query.setParameter("uname", username);
		@SuppressWarnings("unchecked")
		List<Customer> persons = query.list();
		return persons.get(0);
	}

}