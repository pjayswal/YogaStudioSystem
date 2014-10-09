package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Role {
	

	@Transient
	public static String ROLE_ADMIN ="ROLE_ADMIN";
	

	@Transient
	public static String ROLE_CUSTOMER = "ROLE_CUSTOMER";

	@Transient
	public static String ROLE_FACULTY = "ROLE_FACULTY";
	
	@Id @GeneratedValue
	private long id;
	private String role;
	
	public Role() {
		// default constructor
	}
	
	public Role(String role){
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

		
	
}
