package org.ys.commons;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {
	@Id @GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	private Date paidDate;
	private double total;
	private String details;
	@OneToOne
	private Order order;

	public Payment() {

	}	
	
	public Payment( Date paidDate, double total, String details, Order order) {
		super();
		this.paidDate = paidDate;
		this.total = total;
		this.details = details;
		this.order = order;
		
		order.setPayment(this);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public Date getPaidDate() {
		return paidDate;
	}
	
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}	
}
