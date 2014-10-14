package org.ys.clientservices;

import java.util.List;

import org.ys.commons.Category;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Order;
import org.ys.commons.Product;
import org.ys.commons.Section;
import org.ys.commons.Semester;

public interface IAdminService {
	
	public void addFaculty(Faculty faculty);
	public void updateFaculty(Faculty faculty);
	public void deleteFaculty(Faculty faculty);
	
	public void addSemester(Semester semester);
	public void updateSemester(Semester semester);
	public void deleteSemester(Semester semester);
	
	public void addSection(Section section);
	public void updateSection(Section section);
	public void deleteSection(Section section);
	
	public void addCourse(Course course);
	public void updateCourse(Course course);
	public void deleteCourse(Course course);
	
	public void updateCustomer(Customer customer);
	
	public void addProduct(Product Product);
	public void updateProduct(Product Product);
	public void deleteProduct(Product Product);
	
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	
	public Customer getCustomer(long id);
	public Course getCourse(long id);
	public Section getSection(long id);
	public Semester getSemester(long id);
	public Faculty getFaculty(long id);
	public Product getProduct(long id);
	public Category getCategory(long id);
	public Order getOrder(long id);
	
	public List<Customer> getCustomers();
	public List<Course> getCourses();
	public List<Section> getSections();
	public List<Semester> getSemesters();
	public List<Faculty> getFaculties();
	public List<Product> getProducts();
	public List<Category> getCategories();
	public List<Order> getOrders();
	

}
