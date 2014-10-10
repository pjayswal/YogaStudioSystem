package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Customer extends Person {

	@ManyToOne
	private Faculty advisor;
	@OneToMany(mappedBy="customer")
	private List<Waiver> waivers = new ArrayList<Waiver>();
	@ManyToMany
	@JoinTable(name="enrollment",
			joinColumns={@JoinColumn(name="customer_id")},
			inverseJoinColumns={@JoinColumn(name="section_id")})
	private List<Section> enrolledSections = new ArrayList<Section>();
	@ManyToMany
	@JoinTable(name="waitinglist",
			joinColumns={@JoinColumn(name="customer_id")},
			inverseJoinColumns={@JoinColumn(name="section_id")})
	private List<Section> waitListSections = new ArrayList<Section>();
	@OneToOne
	@JoinColumn(name="cart_id")
	private ShoppingCart shoppingCart;
	@OneToMany(mappedBy="customer")
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

	public List<Section> getWaitListSections() {
		return waitListSections;
	}

	public void addWaitListSections(Section waitListSection) {
		this.waitListSections.add(waitListSection);
	}

	
	
}
