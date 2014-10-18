package org.ys.commons;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;



@Entity
public class Waiver {
	@Transient
	public static String STATUS_UNSEEN="UNSEEN";
	@Transient
	public static String STATUS_WAIVED="WAIVED";
	@Transient
	public static String STATUS_REJECTED="REJECTED";
	
	@Id @GeneratedValue
	private long id;
	@OneToOne
	private Course course;
	private String description;
	@ManyToOne
	private Customer customer;
	private String status;
	
	public Waiver() {
	}
	
	public Waiver( Course course) {
		super();
		this.status=STATUS_UNSEEN;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
