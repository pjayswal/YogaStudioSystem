package org.ys.commons;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	private String name;
	private String email;
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private Address address;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private UserCredential user;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	
	public Person(String name, String email, String phone,Date dob, 
			UserCredential user) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		
		this.user = user;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public UserCredential getUser() {
		return user;
	}

	public void setUser(UserCredential user) {
		this.user = user;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public long getId() {
		return id;
	}


	
	
	
}
