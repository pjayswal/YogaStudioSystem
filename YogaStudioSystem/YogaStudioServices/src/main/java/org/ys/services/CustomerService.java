package org.ys.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.ICustomerService;
import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Role;
import org.ys.commons.Section;
import org.ys.commons.ShoppingCart;
import org.ys.commons.Waiver;
import org.ys.helper.SectionDataSet;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IFacultyDAO;
import org.ys.idao.IRoleDAO;
import org.ys.idao.ISectionDAO;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private IFacultyDAO facultyDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	@Autowired
	private IRoleDAO roleDAO;

	public void addCustomer(Customer customer) {
		Role role = roleDAO.get(Role.ROLE_CUSTOMER_ID);
		customer.getUser().addRole(role);
		customer.setShoppingCart(new ShoppingCart());
		customerDAO.create(customer);

	}

	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
	}

	public void disableCustomer(Customer customer) {
		customer.getUser().setEnabled(false);
		customerDAO.update(customer);
	}

	public void assignAdvisor(Customer customer, Faculty faculty) {
		customer.setAdvisor(faculty);
	}

	public List<Section> getCurrentSections() {
		// get current sections
		return sectionDAO.getAll();

	}

	public void enrollSection(Customer customer, Section section) {
		List<Faculty> faculties = facultyDAO.getAll();
		Random r = new Random();
		int id = r.nextInt(faculties.size());

		if (customer.getAdvisor() == null) {
			customer.setAdvisor(faculties.get(id));
		}
		section.addEnrolledCustomers(customer);
		sectionDAO.update(section);
	}

	public List<Course> getUnfullfilledPrerequisites(Customer customer,
			Section section) {
		List<Section> customerSections = customer.getEnrolledSections();
		List<Waiver> customerWaivers = customer.getWaivers();

		Course course = section.getCourse();
		List<Course> prerequisites = course.getPrerequisites();

		List<Course> unfullfilledPrerequisites = new ArrayList<Course>();
		for (Course c : prerequisites) {
			int metPrerequisite = 0;
			for (Section s : customerSections) {
				if (s.getCourse().equals(c))
					metPrerequisite = 1;
			}
			if (metPrerequisite == 0) {
				unfullfilledPrerequisites.add(c);
			}
		}
		return unfullfilledPrerequisites;

	}

	public void withdrawSection(Customer customer, Section section) {
		section.getEnrolledCustomers().remove(customer);
		customer.getEnrolledSections().remove(section);
		sectionDAO.update(section);
		customerDAO.update(customer);

	}

	public void addWaiverRequest(Customer customer, Waiver waiver) {
		List<Faculty> faculty = facultyDAO.getAll();

		if (customer.getAdvisor() == null) {
			customer.setAdvisor(faculty.get(0));
		}
		customer.addWaiver(waiver);
		waiver.setStatus(Waiver.STATUS_UNSEEN);
		customerDAO.update(customer);
	}

	public void requestWaitingList(Customer customer, Section section) {
		// TODO Auto-generated method stub

	}

	public Customer getCustomer(long id) {
		return customerDAO.get(id);

	}

	public List<SectionDataSet> getSections(Customer customer) {
		List<SectionDataSet> sectionDataSet = new ArrayList<SectionDataSet>();
		for (Section section : sectionDAO.getAll()) {
			sectionDataSet.add(new SectionDataSet(customer, section));
		}
		return sectionDataSet;
	}

}
