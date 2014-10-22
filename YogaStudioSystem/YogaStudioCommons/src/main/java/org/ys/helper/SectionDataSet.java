package org.ys.helper;

import java.util.ArrayList;
import java.util.List;

import org.ys.commons.Course;
import org.ys.commons.Customer;
import org.ys.commons.Section;
import org.ys.commons.Waiver;

public class SectionDataSet {
	public static String ENROLL="ENROLL";
	public static String WAIVE ="WAIVE";
	public static String ENROLLED = "ENROLLED";
	public static String PENDING = "PENDING";
	public static String ACCEPTED = "ACCEPTED";
	public static String REJECTED = "REJECTED";
	private Section section;
	private String option;
	private List<Course> unfullfilledPrerequisites = new ArrayList<Course>();
	public SectionDataSet(Customer customer, Section section) {
		this.section = section;
		if(section.getEnrolledCustomers().contains(customer))
			option=ENROLLED;
		else{
			
			List<Section> customerSections = customer.getEnrolledSections();
			List<Waiver> customerWaivers = customer.getWaivers();

			Course course = section.getCourse();
			List<Course> prerequisites = course.getPrerequisites();
			int haveWaiver=0;
			
			for (Course c : prerequisites) {
				int metPrerequisite = 0;
				int fulfilledWaiver=0;
				for (Section s : customerSections) {
					if (s.getCourse().equals(c))
						metPrerequisite = 1;
				}	
				if (metPrerequisite == 0) {
					
					for(Waiver w:customerWaivers){
						if(w.getCourse()==c){
							haveWaiver=1;
							if(w.getStatus().equals(Waiver.STATUS_WAIVED)){
								fulfilledWaiver=1;
							}
						}
					}
					if(haveWaiver==1)
						unfullfilledPrerequisites.add(c);
					if(!(haveWaiver==1&&fulfilledWaiver==1))
						unfullfilledPrerequisites.add(c);
				}
			}
			if(haveWaiver==0&&unfullfilledPrerequisites.size()==0){
				option=ENROLL;
			}
			else if(haveWaiver==0&&unfullfilledPrerequisites.size()!=0){
				option=WAIVE;
			}
			else if(haveWaiver==1&&unfullfilledPrerequisites.size()==0){
				option=ENROLL;
			}
			else if(haveWaiver==1&&unfullfilledPrerequisites.size()!=0){
				option=PENDING;
			
				int flag=1;//for accepted
				int unseen=1;//for not seen
				int waive=1;//  waiver for all  
				for(Course c:unfullfilledPrerequisites){
					int w1=0;
					List<Waiver> waivers = customer.getWaivers();
					for(Waiver w:waivers){
						
						if(w.getCourse()==c){
							w1=1;
							if(w.getStatus().equals(Waiver.STATUS_REJECTED)){
								flag=0;
								unseen=0;
							}
							else if(w.getStatus().equals(Waiver.STATUS_WAIVED)){
								unseen=0;
							}
						}
					}
					if(w1!=1){
						waive=0;
					}
				}
				if(waive==0)
					option=WAIVE;
				else if(flag==0){
					option=REJECTED;
				}
				else if(unseen==1){
					option=PENDING;
				}
				else if(flag==1){
					option=ACCEPTED;
				}
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
