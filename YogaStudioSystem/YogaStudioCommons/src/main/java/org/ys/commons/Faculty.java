package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {
	
	private String bio;
	@OneToMany(mappedBy="advisor")
	private List<Customer> advisees=new ArrayList<Customer>();
	@OneToMany(mappedBy="faculty",fetch=FetchType.EAGER)
	private List<Section> takingSections=new ArrayList<Section>();
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="faculty_id")
	private List<Waiver> waiverRequests=new ArrayList<Waiver>();
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(String bio,String name, String email, String phone, Date dob,
			UserCredential user) {
		super(name, email, phone,dob, user);
		this.bio = bio;
	}


	public void internalAddAdvisee(Customer advisee) {
		advisees.add(advisee);
	}
	

	public void internalAddTakingSection(Section takingSection) {
		takingSections.add(takingSection);
	}
	

	public void internalAddWaiverRequest(Waiver waiver) {
		waiverRequests.add(waiver);
	}


	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Customer> getAdvisees() {
		return advisees;
	}

	public void setAdvisees(List<Customer> advisees) {
		this.advisees = advisees;
	}

	public List<Section> getTakingSections() {
		return takingSections;
	}

	public void setTakingSections(List<Section> takingSections) {
		this.takingSections = takingSections;
	}

	public List<Waiver> getWaiverRequests() {
		return waiverRequests;
	}

	public void setWaiverRequests(List<Waiver> waiverRequests) {
		this.waiverRequests = waiverRequests;
	}


}
