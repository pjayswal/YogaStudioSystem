package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="user")
public class UserCredential {
	
	@Id
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private boolean enabled=false;
	
	@ManyToMany
	@JoinTable(name="user_role",
			joinColumns={@JoinColumn(name="username")},
			inverseJoinColumns={@JoinColumn(name="role_id")})
	private List<Role> roles= new ArrayList<Role>();
	
	public UserCredential() {
		// TODO Auto-generated constructor stub
	}
	public UserCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void addRole(Role role){
		roles.add(role);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserCredential [username=" + username + ", password="
				+ password + ", enabled=" + enabled + "]";
	}
	
	
	

}
