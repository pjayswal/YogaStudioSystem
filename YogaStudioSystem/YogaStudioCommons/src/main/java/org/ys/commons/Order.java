package org.ys.commons;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Order {
	@Id @GeneratedValue
	private long Id;
	
	private Date orderDate;
	private Date shipDate;
	private Address shipTo;
	private String status;
	private double sum;
	

	public Order() {
		
	}
	
	public Order(long id, Date orderDate, Date shipDate, Address shipTo,
			String status, double sum) {
		super();
		Id = id;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.shipTo = shipTo;
		this.status = status;
		this.sum = sum;
	}
	
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
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
