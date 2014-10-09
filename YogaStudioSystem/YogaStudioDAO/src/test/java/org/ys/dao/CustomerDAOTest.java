package org.ys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import junit.framework.TestCase;

@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerDAOTest extends TestCase {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Test
    public void testContext() {
        assertNotNull(customerDAO);
    }
	
	/**
	 * Test of create method of CustomerDAO
	 */
	@Test
	public void testCreate() {
		System.out.println("Create Customer");
		/*UserCredential upramod = new UserCredential("pramod", "jayswal");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "prmaod@gmail.com", "988-21312321", DateUtil.convert("1234/12/12"), upramod);
		customerDAO.create(customer);*/

	}
	

}
