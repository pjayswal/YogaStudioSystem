package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id @GeneratedValue
	private long id;

	private String name;
	private List<Product> products = new ArrayList<Product>();
	
	public Category() {
		
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}		
}
