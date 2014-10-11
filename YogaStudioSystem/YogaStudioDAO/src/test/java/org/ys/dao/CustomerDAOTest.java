package org.ys.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import org.ys.commons.Customer;
import org.ys.commons.Role;
import org.ys.commons.UserCredential;

import junit.framework.TestCase;

@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

public class CustomerDAOTest extends TestCase {
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private UserCredentialDAO userDAO;
	@Test
    public void testContext() {
        assertNotNull(customerDAO);
        assertNotNull(userDAO);
    }
	
	/**
	 * Test of create method of CustomerDAO
	 */
	@Test
	@Rollback(false)
	public void testCreate() {
		System.out.println("Create Customer");
		
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		Role roleCustomer = new Role("ROLE_CUSTOMER");
		upramod.addRole(roleCustomer);
		//Date date = new Date();
		Customer customer = new Customer("Pramod", "prmaod@gmail.com", "988-21312321", new Date(), upramod);
		customerDAO.create(customer);
		
		UserCredential user=userDAO.get("pramod");
		assertEquals("pramod", user.getUsername());
	}
	

}
