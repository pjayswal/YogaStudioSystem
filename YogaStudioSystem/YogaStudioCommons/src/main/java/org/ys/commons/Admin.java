package org.ys.commons;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Admin extends Person{

	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String phone, Date dob,
			UserCredential user) {
		super(name, email, phone,dob, user);
	}

	
	
	
}
