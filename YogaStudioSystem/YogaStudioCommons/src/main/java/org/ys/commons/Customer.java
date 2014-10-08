package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer extends Person {
	@Id @GeneratedValue
	private long id;

	private Faculty advisor;
	private List<Waiver> waivers = new ArrayList<Waiver>();
	private List<Section> enrolledSections = new ArrayList<Section>();
	private ShoppingCart shoppingCart;
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, String phone, Date dob,
			UserCredential user) {
		super(name, email, phone, dob,user);
	}



	public void addWaiver(Waiver waiver) {
		this.waivers.add(waiver);
	}


	public void addEnrolledSection(Section section) {
		this.enrolledSections.add(section);
	}


	public void addOrder(Order order) {
		this.orders.add(order);
	}


	public Faculty getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Faculty advisor) {
		this.advisor = advisor;
	}

	public List<Waiver> getWaivers() {
		return waivers;
	}

	public void setWaivers(List<Waiver> waivers) {
		this.waivers = waivers;
	}

	public List<Section> getEnrolledSections() {
		return enrolledSections;
	}

	public void setEnrolledSections(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public long getId() {
		return id;
	}
	
}
