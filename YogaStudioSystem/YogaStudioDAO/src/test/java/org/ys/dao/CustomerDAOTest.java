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
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Role;
import org.ys.commons.Section;
import org.ys.commons.Semester;
import org.ys.commons.UserCredential;
import org.ys.commons.Waiver;
import org.ys.idao.ICourseDAO;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IFacultyDAO;
import org.ys.idao.IRoleDAO;
import org.ys.idao.ISectionDAO;
import org.ys.idao.ISemesterDAO;
import org.ys.idao.IUserCredentialDAO;
import org.ys.idao.IWaiverDAO;

@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

public class CustomerDAOTest extends TestCase {
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private IUserCredentialDAO userDAO;
	@Autowired
	private IRoleDAO roleDAO;
	@Autowired
	private IFacultyDAO facultyDAO;
	@Autowired
	private IWaiverDAO waiverDAO;
	@Autowired
	private ICourseDAO courseDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	@Autowired
	private ISemesterDAO semesterDAO;
	
	@Test
    public void testContext() {
        assertNotNull(customerDAO);
        assertNotNull(userDAO);
        assertNotNull(roleDAO);
        assertNotNull(facultyDAO);
        assertNotNull(waiverDAO);
        assertNotNull(courseDAO);
    	
	
	}
	
	/**
	 * Test of create method of CustomerDAO
	 */
	@Test
	public void testCreate() {
		System.out.println("Create Customer");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		//instantiating a customer
		UserCredential upramod = new UserCredential("pramod", "jayswal");

		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		assertNotNull(customer.getId());
		assertEquals(1,customerDAO.getAll().size());
		assertEquals(1,userDAO.getAll().size());
		assertEquals(1, roleDAO.getAll().size());
		
	}
	
	/**
	 * Test of update method of CustomerDAO
	 */
	@Test
	public void testUpdate(){
		
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		roleDAO.create(roleFaculty);
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		//updating with advisor
		UserCredential unoman = new UserCredential("noman", "mannan");
		unoman.addRole(roleFaculty);
		
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		facultyDAO.create(advisor);
		customer.setAdvisor(advisor);
		customerDAO.update(customer);
		
		List<Faculty> faculties = facultyDAO.getAll();
		assertEquals(1, faculties.size());
		assertEquals(1, faculties.get(0).getAdvisees().size());
		assertEquals(customer, faculties.get(0).getAdvisees().get(0));
		
		//updating with waiver
		Course course = new Course("cs435", "databse", "DBMS");
		courseDAO.create(course);
		Waiver waiver = new Waiver(course);
		customer.addWaiver(waiver);
		customerDAO.update(customer);
		assertNotNull(course.getId());
		assertNotNull(waiver.getId());
		assertEquals(1, waiverDAO.getAll().size());
		assertEquals(1, courseDAO.getAll().size());
		
		//update enrolled Section
		Semester semester = new Semester();
		semesterDAO.create(semester);
		Section section = new Section(course, semester, 3, advisor);
		sectionDAO.create(section);
		section.addEnrolledCustomers(customer);
		sectionDAO.update(section);
		
	}
	/**
	 * Testing delete method of CustomerDAO
	 */
	@Test
	public void testDelete() {
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		roleDAO.create(roleFaculty);
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		//add advisor
		UserCredential unoman = new UserCredential("noman", "mannan");
		unoman.addRole(roleFaculty);
		
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		facultyDAO.create(advisor);
		customer.setAdvisor(advisor);
		customerDAO.update(customer);
		
		//add waiver
		Course course = new Course("cs435", "databse", "DBMS");
		courseDAO.create(course);
		Waiver waiver = new Waiver(course);
		customer.addWaiver(waiver);
		customerDAO.update(customer);
		assertNotNull(course.getId());
		assertNotNull(waiver.getId());
		assertEquals(1, waiverDAO.getAll().size());
		assertEquals(1, courseDAO.getAll().size());
		
		//add enrolled Section
		Semester semester = new Semester();
		semesterDAO.create(semester);
		Section section = new Section(course, semester, 3, advisor);
		sectionDAO.create(section);
		section.addEnrolledCustomers(customer);
		sectionDAO.update(section);
		
		
		customerDAO.delete(customer);
		assertEquals(1, sectionDAO.getAll().size());
		 try {
			 Customer nullCus = customerDAO.get(customer.getId());
			 assertNull(nullCus);
			 } catch (Exception e) {
			 assertEquals(org.hibernate.ObjectNotFoundException.class, e.getClass());
			 System.out.println("Not found: customer " + customer.getId());
			 }
		assertEquals(1, facultyDAO.getAll().size());
		 try {
			 Waiver nullWaiver = waiverDAO.get(waiver.getId());
			 assertNull(nullWaiver);
			 } catch (Exception e) {
			 assertEquals(org.hibernate.ObjectNotFoundException.class, e.getClass());
			 System.out.println("Not found: waiver " + waiver.getId());
			 }
		assertEquals(1, courseDAO.getAll().size());
	

	}
	

}
