package org.ys.dao;

import junit.framework.TestCase;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.commons.Semester;
import org.ys.commons.UserCredential;
import org.ys.idao.ICourseDAO;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IFacultyDAO;
import org.ys.idao.ISectionDAO;
import org.ys.idao.ISemesterDAO;
import org.ys.idao.IUserCredentialDAO;

@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SemesterDAOTest extends TestCase {

	@Autowired
	private ISemesterDAO semesterDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	@Autowired
	private ICourseDAO courseDAO;
	@Autowired
	private IFacultyDAO facultyDAO;
	@Autowired
	private IUserCredentialDAO userDAO;
	@Autowired
	private ICustomerDAO customerDAO;

	@Test
	public void testContext() {
		assertNotNull(semesterDAO);
	}

	/**
	 * Test of Create Method of SemesterDao
	 */
	public void testCreate() {
		System.out.println("Creating Semester");
		Semester semester = new Semester("Block1", "June 2014", new Date(),
				new Date());
		semesterDAO.create(semester);

		assertNotNull(semester.getId());
	}

	/**
	 * Test of Update Method of SemesterDao
	 */
	@Test
	public void testUpdate() {
		Semester semester = new Semester("Block1", "June 2014", new Date(),
				new Date());
		semesterDAO.create(semester);
		semester.setName("Block2");
		semester.setDescription("October 2014");
		semesterDAO.update(semester);
		assertEquals("Block2", semesterDAO.get(semester.getId()).getName());
		assertEquals("October 2014", semesterDAO.get(semester.getId())
				.getDescription());
	}

	/**
	 * Test of Delete Method of SemesterDao
	 */
	@Test
	public void testDelete() {
		Semester semester = new Semester("Block1", "June 2014", new Date(),
				new Date());
		semesterDAO.create(semester);

		Course course = new Course("CS435", "SWE", "Software Engineering");
		courseDAO.create(course);
		UserCredential user = new UserCredential("noman", "noman654321");
		Faculty faculty = new Faculty("Noman Bio", "Noman Bin Mannan",
				"noman@gmail.com", "55645456567", new Date(), user);
		facultyDAO.create(faculty);
		Section section = new Section(course, semester, 30, faculty);
		sectionDAO.create(section);

		Customer customer = new Customer("Noman", "Noman@gmail.com",
				"989877676", new Date(), user);
		customerDAO.create(customer);

		// delete the semester
		semesterDAO.delete(semester);

		assertEquals(0, semesterDAO.get(semester.getId()).getSections().size());
		assertEquals(1, facultyDAO.getAll().size());
		assertEquals(1, customerDAO.getAll().size());
	}
}
