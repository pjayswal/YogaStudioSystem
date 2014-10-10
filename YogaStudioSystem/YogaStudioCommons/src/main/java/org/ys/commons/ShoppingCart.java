package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ShoppingCart {
	@Id @GeneratedValue
	private long id;		
	@OneToMany
	@JoinTable(name="cart_orderline",
			joinColumns={@JoinColumn(name="cart_id")},
			inverseJoinColumns={@JoinColumn(name="orderline_id")})
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void addOrderLine(OrderLine orderline) {
		this.orderlines.add(orderline);
	}

	public void removeOrderLine(OrderLine orderline) {
		this.orderlines.remove(orderline);
	}
}
