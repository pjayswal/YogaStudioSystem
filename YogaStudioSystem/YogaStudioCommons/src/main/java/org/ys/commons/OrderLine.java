package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderLine {
	@Id @GeneratedValue
	private long id;
	
	private long orderid;
	private long productid;
	private int quantity;
	private double price;
	private double amount;
	private Product product;
	private Order order;
	private ShoppingCart shoppingcart;
	
	public OrderLine() {
		
	}	
	
	public OrderLine(long id, long orderid, long productid, int quantity,
			double price, double amount, Product product, Order order, ShoppingCart shoppingcart) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.productid = productid;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		this.product = product;
		this.order = order;
		this.shoppingcart = shoppingcart;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
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
	
	public long getOrderid() {
		return orderid;
	}
	
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public long getProdudtd() {
		return productid;
	}
	
	public void setProdudtd(long productid) {
		this.productid = productid;
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
