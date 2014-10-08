package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingCart {
	@Id @GeneratedValue
	private long id;
	
	private Date createDate;	
	private Customer customer;
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	
	public ShoppingCart(long id, Date createDate, Customer customer,
			List<OrderLine> orderlines) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.customer = customer;
		this.orderlines = orderlines;
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

	public void addOrderLine(OrderLine orderline) {
		this.orderlines.add(orderline);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}	
}
