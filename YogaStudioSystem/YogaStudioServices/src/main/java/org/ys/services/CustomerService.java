package org.ys.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.ICustomerService;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.ISectionDAO;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	
	public void addCustomer(Customer customer) {
		customerDAO.create(customer);
		
	}

	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
	}

	public void disableCustomer(String username) {
		Customer customer = customerDAO.getCustomer(username);
		customer.getUser().setEnabled(false);
		customerDAO.update(customer);
	}

	public void assignAdvisor(String username,Faculty faculty) {
		Customer customer = customerDAO.getCustomer(username);
		customer.setAdvisor(faculty);
	}
	
	public List<Section> getCurrentSections() {
		//get current sections
		return sectionDAO.getAll();
		
	}

	public List<Course> enrollSection(String username, Section section) {
		Customer customer = customerDAO.getCustomer(username);
		Course course = section.getCourse();
		List<Course> prerequisites = course.getPrerequisites();
		List<Section> customerSections = customer.getEnrolledSections();
		List<Course> unfullfilledPrerequisites = new ArrayList<Course>();
		for(Course c: prerequisites){
			int metPrerequisite=0;
			for(Section s:customerSections){
				if(s.getCourse().equals(c))
					metPrerequisite=1;
			}
			if(metPrerequisite==0){
				unfullfilledPrerequisites.add(c);
			}
		}
		if(unfullfilledPrerequisites.size()==0){
			section.addEnrolledCustomers(customer);
			sectionDAO.update(section);
			return null;
		}
		else return unfullfilledPrerequisites;
	}

	public void withdrawSection(String username, Section section) {
		// TODO Auto-generated method stub
		
	}

	public void requestWaiver(String username, Section section,
			String description) {
		// TODO Auto-generated method stub
		
	}

	public void requestWaitingList(String username, Section section) {
		// TODO Auto-generated method stub
		
	}

	public void getCustomer(long id) {
		// TODO Auto-generated method stub
		
	}


}
