package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderLine {
	@Id @GeneratedValue
	private long id;
	
	private long orderid;
	private long produdtd;
	private int quantity;
	private double price;
	private double amount;
	
	public OrderLine() {
		
	}	
	
	public OrderLine(long id, long orderid, long produdtd, int quantity,
			double price, double amount) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.produdtd = produdtd;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getOrderid() {
		return orderid;
	}
	
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public long getProdudtd() {
		return produdtd;
	}
	
	public void setProdudtd(long produdtd) {
		this.produdtd = produdtd;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
