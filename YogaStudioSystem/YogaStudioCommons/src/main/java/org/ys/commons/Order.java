package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="orders")
public class Order {
	@Id @GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@Temporal(TemporalType.DATE)
	private Date shippingDate;
	@Embedded
	private Address shippingAddress;
	private String status;
	private double totalAmount;
	@OneToOne(mappedBy="order")
	private Payment payment;
	@ManyToOne
	private Customer customer;
	@OneToMany
	@JoinColumn(name="order_id")
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	

	public Order() {
		
	}
	
	public Order(Date orderDate, Date shippingDate, Address shippingAddress,
			String status, Customer customer, ShoppingCart shoppingCart) {
		super();
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.customer = customer;
		this.orderlines = shoppingCart.getOrderlines();
		this.totalAmount = computeTotalAmount(shoppingCart);
		this.status = status;
		customer.internalAddOrder(this);
	}

	
	public double computeTotalAmount(ShoppingCart shoppingCart){
		double totalAmount=0;
		for(OrderLine ol:shoppingCart.getOrderlines()){
			totalAmount += ol.getAmount();
		}
		return totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	public long getId() {
		return id;
	}
	
}
