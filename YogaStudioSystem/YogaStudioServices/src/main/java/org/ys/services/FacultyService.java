package org.ys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.IFacultyService;
import org.ys.commons.Customer;
import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.commons.Waiver;
import org.ys.idao.ICustomerDAO;
import org.ys.idao.IFacultyDAO;
import org.ys.idao.ISectionDAO;
import org.ys.idao.IWaiverDAO;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FacultyService implements IFacultyService {
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private IFacultyDAO facultyDAO;
	@Autowired
	private IWaiverDAO waiverDAO;
	@Autowired
	private ISectionDAO sectionDAO;

	public List<Waiver> getWaiverRequests(String username) {
		Faculty faculty = facultyDAO.getFaculty(username);
		return faculty.getWaiverRequests();
	}

	public List<Section> getCurrentSections(String username) {
		Faculty faculty = facultyDAO.getFaculty(username);
		return faculty.getTakingSections();
	}

	public void approveWaiver(String username, Waiver waiver) {
		Customer customer = customerDAO.getCustomer(username);
		waiver.setStatus("WAIVED");
		customerDAO.update(customer);
		waiverDAO.update(waiver);
	}

	public void rejectWaiver(String username, Waiver waiver) {
		Customer customer = customerDAO.getCustomer(username);
		waiver.setStatus("REJECTED");
		customerDAO.update(customer);
		waiverDAO.update(waiver);
	}

}