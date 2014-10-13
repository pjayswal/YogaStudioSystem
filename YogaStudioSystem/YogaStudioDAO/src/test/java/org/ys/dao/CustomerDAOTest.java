package org.ys.dao;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Role;
import org.ys.commons.UserCredential;
import org.ys.idao.ICustomerDAO;

@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

public class CustomerDAOTest extends TestCase {
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private UserCredentialDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private FacultyDAO facultyDAO;
	@Test
    public void testContext() {
        assertNotNull(customerDAO);
        assertNotNull(userDAO);
        assertNotNull(roleDAO);
	}
	
	/**
	 * Test of create method of CustomerDAO
	 */
	@Test
	public void testCreate() {
		System.out.println("Create Customer");
		//instantiating a customer
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		assertNotNull(customer.getId());
		assertEquals(customer, customerDAO.get(customer.getId()));
		UserCredential user=userDAO.get("pramod");
		assertEquals("pramod", user.getUsername());
		
		//assigning a faculty
		
	}
	
	/**
	 * Test of update method of CustomerDAO
	 */
	@Test
	public void testUpdate(){
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		//updating with advisor
		UserCredential unoman = new UserCredential("noman", "mannan");
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		unoman.addRole(roleFaculty);
		
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		customer.setAdvisor(advisor);
		customerDAO.update(customer);
		
		List<Faculty> faculties = facultyDAO.getAll();
		assertEquals(1, faculties.size());
		assertEquals(1, faculties.get(0).getAdvisees().size());
		assertEquals(customer, faculties.get(0).getAdvisees().get(0));
		
		//
	}
	

}
