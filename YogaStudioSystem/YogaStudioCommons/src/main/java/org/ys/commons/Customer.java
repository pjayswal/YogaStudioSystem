package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer extends Person {
	@Id @GeneratedValue
	private long id;

	private Date dob;
	private Faculty advisor;
	private List<Waiver> waivers = new ArrayList<Waiver>();
	private List<Section> takenSections = new ArrayList<Section>();
	private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(long id, Date dob, Faculty advisor) {
		super();
		this.id = id;
		this.dob = dob;
		this.advisor = advisor;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Faculty getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Faculty advisor) {
		this.advisor = advisor;
	}

	private void addWaiver(Waiver waiver) {
		this.waivers.add(waiver);
	}

	private void addTakenSection(Section section) {
		this.takenSections.add(section);
	}

	private void addShoppingCarts(ShoppingCart shoppingCart) {
		this.shoppingCarts.add(shoppingCart);
	}

	private void addOrder(Order order) {
		this.orders.add(order);
	}
}
