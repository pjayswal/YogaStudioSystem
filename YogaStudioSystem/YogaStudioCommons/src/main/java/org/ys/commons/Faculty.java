package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faculty extends Person {
	@Id @GeneratedValue
	private long id;
	
	private String profile;
	private List<Customer> advisees=new ArrayList<Customer>();
	private List<Section> takingSections=new ArrayList<Section>();
	private List<Waiver> waiverRequest=new ArrayList<Waiver>();
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}
	
	public Faculty(long id, String profile) {
		super();
		this.id = id;
		this.profile = profile;
	}

	private void addAdvisees(Customer advisee) {
		this.advisees.add(advisee);
	}
	
	private void addTakingSection(Section takingSection) {
		this.takingSections.add(takingSection);
	}
	
	private void addWaiverRequest(Waiver waiver) {
		this.waiverRequest.add(waiver);
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public List<Customer> getAdvisees() {
		return advisees;
	}

	public List<Section> getTakingSections() {
		return takingSections;
	}

	public List<Waiver> getWaiverRequest() {
		return waiverRequest;
	}
}
