package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderLine {
	@Id @GeneratedValue
	private long Id;
	
	private long orId;
	private int quantity;
	private double price;
	private double amount;
}
