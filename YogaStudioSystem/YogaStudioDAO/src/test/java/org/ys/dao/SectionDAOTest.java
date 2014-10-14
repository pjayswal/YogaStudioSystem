package org.ys.dao;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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

public class SectionDAOTest extends TestCase {
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
        assertNotNull(sectionDAO);
        assertNotNull(semesterDAO);
	}
	
	/**
	 * Test of create method of SectionDAO
	 */
	@Test
	public void testCreate() {
		System.out.println("Create Section");
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		roleDAO.create(roleFaculty);
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		//instantiating a Section
		UserCredential unoman = new UserCredential("noman", "mannan");
		unoman.addRole(roleFaculty);
		
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		facultyDAO.create(advisor);
		
		Course course = new Course("CS425", "SE", "Software Engineering");
		courseDAO.create(course);
		
		Semester semester = new Semester("Fall", "Fall Semester", new Date(), new Date());
		semesterDAO.create(semester);

		Section section = new Section(course, semester, 111, advisor);
		sectionDAO.create(section);
		
		assertNotNull(section.getId());
		
	}
	
	/**
	 * Test of update method of SectionDAO
	 */
	@Test
	public void testUpdate(){
		
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		roleDAO.create(roleFaculty);
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		
		UserCredential unoman = new UserCredential("noman", "mannan");
		unoman.addRole(roleFaculty);
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		facultyDAO.create(advisor);
		
		Course course = new Course("CS425", "SE", "Software Engineering");
		courseDAO.create(course);
		
		Semester semester = new Semester("Fall", "Fall Semester", new Date(), new Date());
		semesterDAO.create(semester);

		Section section = new Section(course, semester, 111, advisor);
		sectionDAO.create(section);
		
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		//update with enrolled customer
		section.addEnrolledCustomers(customer);
		sectionDAO.update(section);
		assertEquals(1,sectionDAO.getAll().get(0).getEnrolledCustomers().size());
		
		UserCredential urahman = new UserCredential("mehbub", "rahman");
		upramod.addRole(roleCustomer);
		Customer new_customer = new Customer("Mehbub", "mehbub@gmail.com", "977-8779876457", new Date(), urahman);
		customerDAO.create(new_customer);
		
		//update with waiting list customer
		section.addWaitingListCustomers(new_customer);
		sectionDAO.update(section);
		assertEquals(1,sectionDAO.getAll().get(0).getWaitingListCustomers().size());
		
		UserCredential urehman = new UserCredential("rehman", "mehbub");
		urehman.addRole(roleFaculty);
		Faculty faculty = new Faculty("Rehman bio", "Rehman Manan", "rehamn@gmail.com", 
				"099-12398657882", new Date(), urehman);
		facultyDAO.create(faculty);
		
		//update with faculty
		advisor.getTakingSections().remove(0);
		sectionDAO.update(section);
		section.setFaculty(faculty);
		facultyDAO.update(faculty);
		//section.setFaculty(faculty);
		//sectionDAO.update(section);
		//assertEquals(faculty.getId(), sectionDAO.getAll().get(0).getFaculty().getId());
		assertEquals(0,facultyDAO.getAll().get(0).getTakingSections().size());
	}
	
	/**
	 * Test of delete method of SectionDAO
	 */
	@Test
	@Rollback(false)
	public void testDelete() {
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		roleDAO.create(roleFaculty);
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		roleDAO.create(roleCustomer);
		
		UserCredential unoman = new UserCredential("noman", "mannan");
		unoman.addRole(roleFaculty);
		Faculty advisor = new Faculty("noman bio", "Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		facultyDAO.create(advisor);
		
		Course course = new Course("CS425", "SE", "Software Engineering");
		courseDAO.create(course);
		
		Semester semester = new Semester("Fall", "Fall Semester", new Date(), new Date());
		semesterDAO.create(semester);

		Section section = new Section(course, semester, 111, advisor);
		sectionDAO.create(section);
		
		UserCredential upramod = new UserCredential("pramod", "jayswal");
		upramod.addRole(roleCustomer);
		Customer customer = new Customer("Pramod", "pramod@gmail.com", "977-9879876457", new Date(), upramod);
		customerDAO.create(customer);
		
		//update with enrolled customer
		section.addEnrolledCustomers(customer);
		sectionDAO.update(section);
		assertEquals(1,sectionDAO.getAll().get(0).getEnrolledCustomers().size());
		
		UserCredential urahman = new UserCredential("mehbub", "rahman");
		upramod.addRole(roleCustomer);
		Customer new_customer = new Customer("Mehbub", "mehbub@gmail.com", "977-8779876457", new Date(), urahman);
		customerDAO.create(new_customer);
		
		//update with waiting list customer
		section.addWaitingListCustomers(new_customer);
		sectionDAO.update(section);
		assertEquals(1,sectionDAO.getAll().get(0).getWaitingListCustomers().size());
		
		UserCredential urehman = new UserCredential("rehman", "mehbub");
		urehman.addRole(roleFaculty);
		Faculty faculty = new Faculty("Rehman bio", "Rehman Manan", "rehamn@gmail.com", 
				"099-12398657882", new Date(), urehman);
		facultyDAO.create(faculty);
		
		//update with faculty
		advisor.getTakingSections().remove(0);
		sectionDAO.update(section);
		section.setFaculty(faculty);
		facultyDAO.update(faculty);
		//section.setFaculty(faculty);
		//sectionDAO.update(section);
		//assertEquals(faculty.getId(), sectionDAO.getAll().get(0).getFaculty().getId());
		assertEquals(0,facultyDAO.getAll().get(0).getTakingSections().size());
		
		sectionDAO.delete(section);
		assertEquals("","");
	

	}
	

}
