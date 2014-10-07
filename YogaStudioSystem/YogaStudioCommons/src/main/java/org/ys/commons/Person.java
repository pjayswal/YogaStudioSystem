package org.ys.commons;

public class Person {
	private String name;
	private String email;
	private String phone;
	private Address address;
	private User user;

	public Person(String name, String email, String phone, Address address,
			User user) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
