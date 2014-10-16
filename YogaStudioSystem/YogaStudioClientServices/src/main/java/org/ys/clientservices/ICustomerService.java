package org.ys.clientservices;

import org.ys.commons.Customer;
import org.ys.commons.Product;
import org.ys.commons.Section;
import org.ys.commons.Semester;

public interface ICustomerService {

	public void addCustomer(Customer customer);
	public void viewCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void loginCustomer(Customer customer);
	public void logoutCustomer(Customer customer);
	
	public void assignAdvisor(Customer customer);
	public void enrollSection(Customer customer,Section section); 
	public void withdrawSection(Customer customer,Section section); 
	public void requestWaiver(Customer customer, Section section, String description);
	public void requestWaitingList(Customer customer, Section section);
	public void browseCourse(Customer customer);
	public void browseSection(Customer customer, Section section);
	public void brwoseSemester(Customer customer, Semester semester);
	
	public void addToCart(Customer customer, Product product);
	public void checkout(Customer customer, Product product);
	public void payment(Customer customer, Product product);
	public void browseProduct(Customer customer, Product product);
	public void browseCategory(Customer customer, Product product);
	
	
	
	
}
