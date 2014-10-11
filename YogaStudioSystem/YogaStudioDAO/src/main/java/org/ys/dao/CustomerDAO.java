package org.ys.dao;

import org.springframework.stereotype.Repository;
import org.ys.commons.Customer;
import org.ys.idao.GenericHibernateDAO;
import org.ys.idao.ICustomerDAO;

@Repository

public class CustomerDAO extends GenericHibernateDAO<Customer, Long> implements ICustomerDAO {

}
