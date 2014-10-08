package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends Person{
	@Id @GeneratedValue
	private long id;
	
	private String type;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
