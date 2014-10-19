package org.ys.clientservices;

import java.util.List;

import org.ys.commons.Section;
import org.ys.commons.Waiver;

public interface IFacultyService {

	public List<Waiver> getWaiverRequests(String username);

	public List<Section> getCurrentSections(String username);

	public void approveWaiver(String username, Waiver waiver);

	public void rejectWaiver(String username, Waiver waiver);

}
