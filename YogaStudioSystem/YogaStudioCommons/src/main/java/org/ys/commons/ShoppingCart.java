package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	@Id @GeneratedValue
	private long id;		
	@OneToMany
	@JoinTable(name="cart_orderline",
			joinColumns={@JoinColumn(name="cart_id")},
			inverseJoinColumns={@JoinColumn(name="orderline_id")})
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void addOrderLine(OrderLine orderline) {
		this.orderLines.add(orderline);
	}

	public void removeOrderLine(OrderLine orderline) {
		this.orderLines.remove(orderline);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrderLines(List<OrderLine> orderlines) {
		this.orderLines = orderlines;
	}
	
}
