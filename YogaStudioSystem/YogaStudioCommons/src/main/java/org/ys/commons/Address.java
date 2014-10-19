package org.ys.commons;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {
	@NotEmpty(message="street is required")
	private String street;
	@NotEmpty(message="city is required")
	private String city;
	@NotEmpty(message="state is required")
	private String state;
	@NotEmpty(message="zip is required")
	private String zipCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String street, String city, String state, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
