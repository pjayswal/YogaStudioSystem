package org.ys.clientservices;

import java.util.List;

import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.commons.Waiver;
import org.ys.helper.SectionDataSet;

public interface ICustomerService {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void disableCustomer(Customer customer);

	public void assignAdvisor(Customer customer, Faculty advisor);

	public List<Section> getCurrentSections();

	public void enrollSection(Customer customer, Section section);

	public List<Course> getUnfullfilledPrerequisites(Customer customer,
			Section section);

	public void withdrawSection(Customer customer, Section section);

	public void addWaiverRequest(Customer customer, Waiver waiver);

	public void requestWaitingList(Customer customer, Section section);

	public Customer getCustomer(long id);
	
	public List<SectionDataSet> getSections(Customer customer);

}