package org.ys.commons;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Waiver {
	@Id @GeneratedValue
	private long id;
	@OneToOne
	private Course course;
	@NotEmpty(message="description is required")
	private String description;
	@ManyToOne
	private Customer customer;
	private boolean status=false;
	
	public Waiver() {
		// TODO Auto-generated constructor stub
	}
	
	public Waiver( Course course) {
		super();
		this.course = course;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
