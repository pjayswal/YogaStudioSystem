package org.ys.clientservices;

import java.util.List;

import org.ys.commons.Faculty;
import org.ys.commons.Section;
import org.ys.commons.Waiver;

public interface IFacultyService {

	public List<Waiver> getWaiverRequests(Faculty faculty);

	public List<Section> getTakingSections(Faculty faculty);

	public void approveWaiver(Waiver waiver);

	public void rejectWaiver(Waiver waiver);

	public Faculty getFaculty(long id);
	
	public Waiver getWaiver(long id);

}
