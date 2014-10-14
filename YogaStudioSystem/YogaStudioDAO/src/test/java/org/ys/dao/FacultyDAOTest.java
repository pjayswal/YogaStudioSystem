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
import org.ys.idao.IFacultyDAO;
import org.ys.idao.ISectionDAO;
import org.ys.idao.ISemesterDAO;
import org.ys.idao.IWaiverDAO;

@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

public class FacultyDAOTest extends TestCase {
	@Autowired
	private IFacultyDAO facultyDAO;
	@Autowired
	private UserCredentialDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private CustomerDAO customerDAO;
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
        assertNotNull(facultyDAO);
        assertNotNull(userDAO);
        assertNotNull(roleDAO);
        assertNotNull(customerDAO);
        assertNotNull(waiverDAO);
        assertNotNull(courseDAO);
        assertNotNull(sectionDAO);
        assertNotNull(semesterDAO);
	}
	
	/**
	 * Test of create method of FacultyDAO
	 */
	@Test
	public void testCreate() {
		System.out.println("Create Faculty");
		//instantiating a faculty
		UserCredential corozza = new UserCredential("Paul", "Corazza");
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		corozza.addRole(roleFaculty);
		Faculty faculty = new Faculty("Professor of Computer Science and Mathematics, B.A., Maharishi International University, M.S., Ph.D., Auburn University", 
									  "Paul Corazza", "pcorazza@mum.edu", "(641) 469-5039", new Date(), corozza);
		facultyDAO.create(faculty);
		assertNotNull(faculty.getId());
		assertEquals(faculty, facultyDAO.get(faculty.getId()));
		UserCredential user=userDAO.get("Paul");
		assertEquals("Paul", user.getUsername());
				
	}
	
	/**
	 * Test of update method of FacultyDAO
	 */
	@Test
	public void testUpdate(){
		UserCredential corozza = new UserCredential("Paul", "Corazza");
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		corozza.addRole(roleFaculty);
		Faculty faculty = new Faculty("Professor of Computer Science and Mathematics, B.A., Maharishi International University, M.S., Ph.D., Auburn University", 
									  "Paul Corazza", "pcorazza@mum.edu", "(641) 469-5039", new Date(), corozza);
		facultyDAO.create(faculty);
		
		//updating with customer
		UserCredential unoman = new UserCredential("Noman", "Manan");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		unoman.addRole(roleCustomer);
		
		Customer customer = new Customer("Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		customer.setAdvisor(faculty);
		
		//updating with waiver
		Course course = new Course("cs435", "databse", "DBMS");
		Waiver waiver = new Waiver(course);
		customer.addWaiver(waiver);
		
		//updating with section
		//Semester semester = new Semester("December","December Block",new Date(), new Date());
		//Section section = new Section(course, semester, 25, faculty);
		
		facultyDAO.update(faculty);

		assertNotNull(course.getId());
		assertNotNull(waiver.getId());

		//assertNotNull(semester.getId());
		//assertNotNull(section.getId());
		
		assertEquals(1, waiverDAO.getAll().size());
		assertEquals(1, courseDAO.getAll().size());

//		assertEquals(1, sectionDAO.getAll().size());
//		assertEquals(1, semesterDAO.getAll().size());

		assertEquals(1, customerDAO.getAll().size());
		assertEquals(faculty, customerDAO.getAll().get(0).getAdvisor());
	}

	
	@Test
	public void testDelete() {

		UserCredential corozza = new UserCredential("Paul", "Corazza");
		Role roleFaculty = new Role(Role.ROLE_FACULTY);
		corozza.addRole(roleFaculty);
		Faculty faculty = new Faculty("Professor of Computer Science and Mathematics, B.A., Maharishi International University, M.S., Ph.D., Auburn University", 
									  "Paul Corazza", "pcorazza@mum.edu", "(641) 469-5039", new Date(), corozza);
		facultyDAO.create(faculty);
		
		//updating with customer
		UserCredential unoman = new UserCredential("Noman", "Manan");
		Role roleCustomer = new Role(Role.ROLE_CUSTOMER);
		unoman.addRole(roleCustomer);
		
		Customer customer = new Customer("Noman Manan", "noman@gmail.com", 
				"099-12398657882", new Date(), unoman);
		customer.setAdvisor(faculty);
		
		//updating with waiver
		Course course = new Course("cs435", "databse", "DBMS");
		Waiver waiver = new Waiver(course);
		customer.addWaiver(waiver);
				
		facultyDAO.update(faculty);

		assertNotNull(course.getId());
		assertNotNull(waiver.getId());

		assertEquals(1, waiverDAO.getAll().size());
		assertEquals(1, courseDAO.getAll().size());

		assertEquals(1, customerDAO.getAll().size());
		assertEquals(faculty, customerDAO.getAll().get(0).getAdvisor());

		facultyDAO.delete(faculty);
		
		
		assertEquals(1, waiverDAO.getAll().size());
		assertEquals(1, customerDAO.getAll().size());
		
	}

}
