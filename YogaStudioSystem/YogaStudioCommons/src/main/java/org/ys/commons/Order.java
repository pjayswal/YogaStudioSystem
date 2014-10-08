package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Order {
	@Id @GeneratedValue
	private long id;
	
	private Date orderDate;
	private Date shipDate;
	private Address shipTo;
	private String status;
	private double sum;
	private Payment payment;
	private Customer customer;
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	

	public Order() {
		
	}
	
	public Order(long id, Date orderDate, Date shipDate, Address shipTo,
			String status, double sum, Customer customer) {
		super();
		id = id;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.shipTo = shipTo;
		this.status = status;
		this.sum = sum;
		this.customer = customer;
	}

	public void addOrderLine(OrderLine orderline) {
		this.orderlines.add(orderline);
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getShipDate() {
		return shipDate;
	}
	
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	
	public Address getShipTo() {
		return shipTo;
	}
	
	public void setShipTo(Address shipTo) {
		this.shipTo = shipTo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
	
}
