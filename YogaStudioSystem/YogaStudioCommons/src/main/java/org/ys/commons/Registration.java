package org.ys.commons;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.ys.commons.UserCredential;

@Entity
public class Registration {
	@Id
	private String uuid;
	@OneToOne
	private UserCredential user;
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	public Registration(UUID uuid ,UserCredential user) {
		this.uuid = uuid.toString();
		this.user =user;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public UserCredential getUser() {
		return user;
	}

	public void setUser(UserCredential user) {
		this.user = user;
	}

	
}
