package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Entity
public class OrderLine {
	@Id @GeneratedValue
	private long id;
	@Min(value=0,message="minimum value 0 is allowed")
	private int quantity;
	@Min(value=0,message="minimum value 0 is allowed")
	private double amount;
	@ManyToOne
	@JoinColumn
	private Product product;
	
	public OrderLine() {
		
	}	
	
	public OrderLine(int quantity, double amount, Product product) {
		super();
		this.quantity = quantity;
		this.amount = amount;
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString(){
		return product.getName()+" x "+quantity+" $"+amount;
	}
}
