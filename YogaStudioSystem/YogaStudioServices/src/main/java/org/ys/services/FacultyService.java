package org.ys.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ys.clientservices.IFacultyService;
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

	public List<Waiver> getWaiverRequests(Faculty faculty) {
		List<Waiver> unseenWaiverList = new ArrayList<Waiver>();
		List<Waiver> waivers = faculty.getWaiverRequests();
		for (Waiver waiver : waivers) {
			if (waiver.getStatus().equals(Waiver.STATUS_UNSEEN)) {
				unseenWaiverList.add(waiver);
			}
		}
		return unseenWaiverList;
	}

	public List<Section> getTakingSections(Faculty faculty) {
		return faculty.getTakingSections();
	}

	public void approveWaiver(Waiver waiver) {
		waiver.setStatus(Waiver.STATUS_WAIVED);
		waiverDAO.update(waiver);
	}

	public void rejectWaiver(Waiver waiver) {
		waiver.setStatus(Waiver.STATUS_REJECTED);
		waiverDAO.update(waiver);
	}

	public Faculty getFaculty(long id) {
		return facultyDAO.get(id);
	}

	public Waiver getWaiver(long id) {
		return waiverDAO.get(id);
	}

}
