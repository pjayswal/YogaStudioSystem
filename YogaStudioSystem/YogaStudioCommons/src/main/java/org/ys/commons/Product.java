package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @GeneratedValue
	private long id;
	
	private long catergoryid;
	private String name;
	private double price;
	

	public Product() {
		
	}
	
	public Product(long id, long catergoryid, String name, double price) {
		super();
		this.id = id;
		this.catergoryid = catergoryid;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCatergoryid() {
		return catergoryid;
	}
	
	public void setCatergoryid(long catergoryid) {
		this.catergoryid = catergoryid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
