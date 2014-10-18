package org.ys.helper;

import java.util.ArrayList;
import java.util.List;

import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Section;

public class SectionDataSet {
	public static String ENROLL="ENROLL";
	public static String WAIVE ="WAIVE";
	public static String ENROLLED = "ENROLLED";
	private Section section;
	private String option;
	private List<Course> unfullfilledPrerequisites = new ArrayList<Course>();
	public SectionDataSet(Customer customer, Section section) {
		this.section = section;
		if(section.getEnrolledCustomers().contains(customer))
			option=ENROLLED;
		else{
			List<Section> customerSections = customer.getEnrolledSections();
			//List<Waiver> customerWaivers = customer.getWaivers();

			Course course = section.getCourse();
			List<Course> prerequisites = course.getPrerequisites();

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
			if(unfullfilledPrerequisites.size()==0){
				option=ENROLL;
			}
			else{
				option=WAIVE;
			}
		}
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public List<Course> getUnfullfilledPrerequisites() {
		return unfullfilledPrerequisites;
	}
	public void setUnfullfilledPrerequisites(List<Course> unfullfilledPrerequisites) {
		this.unfullfilledPrerequisites = unfullfilledPrerequisites;
	}
	
}
