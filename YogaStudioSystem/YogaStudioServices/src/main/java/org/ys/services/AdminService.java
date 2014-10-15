package org.ys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.IAdminService;
import org.ys.commons.Category;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Order;
import org.ys.commons.Product;
import org.ys.commons.Section;
import org.ys.commons.Semester;
import org.ys.idao.ICategoryDAO;
import org.ys.idao.ICourseDAO;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IFacultyDAO;
import org.ys.idao.IOrderDAO;
import org.ys.idao.IProductDAO;
import org.ys.idao.IRoleDAO;
import org.ys.idao.ISectionDAO;
import org.ys.idao.ISemesterDAO;
import org.ys.idao.IUserCredentialDAO;
import org.ys.idao.IWaiverDAO;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class AdminService implements IAdminService{
	
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
	@Autowired
	private IProductDAO productDAO;
	@Autowired
	private ICategoryDAO categoryDAO;
	@Autowired
	private IOrderDAO orderDAO;

	public void addFaculty(Faculty faculty) {
		facultyDAO.create(faculty);
		
	}

	public void updateFaculty(Faculty faculty) {
		facultyDAO.update(faculty);
		
	}

	public void deleteFaculty(Faculty faculty) {
		facultyDAO.delete(faculty);
		
	}

	public void addSemester(Semester semester) {
		semesterDAO.create(semester);
		
	}

	public void updateSemester(Semester semester) {
		semesterDAO.update(semester);
		
	}

	public void deleteSemester(Semester semester) {
		semesterDAO.delete(semester);
		
	}

	public void addSection(Section section) {
		sectionDAO.create(section);
		
	}

	public void updateSection(Section section) {
		sectionDAO.update(section);
		
	}

	public void deleteSection(Section section) {
		sectionDAO.delete(section);
		
	}

	public void addCourse(Course course) {
		courseDAO.create(course);
		
	}

	public void updateCourse(Course course) {
		courseDAO.update(course);
		
	}

	public void deleteCourse(Course course) {
		courseDAO.delete(course);
		
		
	}

	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
		
	}

	public void addProduct(Product product) {
		productDAO.create(product);
		
	}

	public void updateProduct(Product product) {
		productDAO.update(product);
		
	}

	public void deleteProduct(Product product) {
		productDAO.delete(product);		
	}

	public void addCategory(Category category) {
		categoryDAO.create(category);
	}

	public void updateCategory(Category category) {
		categoryDAO.update(category);
		
	}

	public void deleteCategory(Category category) {
		categoryDAO.delete(category);
		
	}

	public Customer getCustomer(long id) {
		return customerDAO.get(id);
	}

	public Course getCourse(long id) {
		return courseDAO.get(id);
	}

	public Section getSection(long id) {
		return sectionDAO.get(id);
	}

	public Semester getSemester(long id) {
		return semesterDAO.get(id);
	}

	public Faculty getFaculty(long id) {
		
		return facultyDAO.get(id);
	}

	public Product getProduct(long id) {
		return productDAO.get(id);
	}

	public Category getCategory(long id) {
		return categoryDAO.get(id);
	}

	public Order getOrder(long id) {
		return orderDAO.get(id);
	}

	public List<Customer> getCustomers() {
		return customerDAO.getAll();
	}

	public List<Course> getCourses() {
		return courseDAO.getAll();
	}

	public List<Section> getSections() {
		return sectionDAO.getAll();

	}

	public List<Semester> getSemesters() {
		return semesterDAO.getAll();

	}

	public List<Faculty> getFaculties() {
		return facultyDAO.getAll();

	}

	public List<Product> getProducts() {
		return productDAO.getAll();

	}

	public List<Category> getCategories() {
		return categoryDAO.getAll();

	}

	public List<Order> getOrders() {
		return orderDAO.getAll();

	}

}
