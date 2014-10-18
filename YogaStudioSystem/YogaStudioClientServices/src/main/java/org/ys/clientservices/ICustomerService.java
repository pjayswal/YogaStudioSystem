package org.ys.clientservices;

import java.util.List;

import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.helper.SectionDataSet;

public interface ICustomerService {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void disableCustomer(String username);

	public void assignAdvisor(String username, Faculty advisor);

	public List<Section> getCurrentSections();

	public void enrollSection(String username, Section section);

	public List<Course> getUnfullfilledPrerequisites(String username,
			Section section);

	public void withdrawSection(String username, Section section);

	public void requestWaiver(String username, Section section,
			String description);

	public void requestWaitingList(String username, Section section);

	public Customer getCustomer(long id);
	
	public List<SectionDataSet> getSections(Customer customer);

}