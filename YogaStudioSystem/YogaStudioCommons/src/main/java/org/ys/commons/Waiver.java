package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Waiver {
	@Id @GeneratedValue
	private long id;
	
	private Faculty faculty;
	private Course course;
	private Customer customer;
	
	public Waiver() {
		// TODO Auto-generated constructor stub
	}
	
	public Waiver(long id, Faculty faculty, Course course, Customer customer) {
		super();
		this.id = id;
		this.faculty = faculty;
		this.course = course;
		this.customer = customer;
	}

	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
