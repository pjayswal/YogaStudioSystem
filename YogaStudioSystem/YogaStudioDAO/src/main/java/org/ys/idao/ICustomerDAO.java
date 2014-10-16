package org.ys.idao;

import org.ys.commons.Customer;

public interface ICustomerDAO extends IGenericDAO<Customer, Long> {
	public Customer getCustomer(String username);
}
