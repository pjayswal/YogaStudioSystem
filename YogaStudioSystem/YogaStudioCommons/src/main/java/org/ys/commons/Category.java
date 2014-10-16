package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id @GeneratedValue
	private long id;

	private String name;
	@OneToMany(mappedBy="category")
	private List<Product> products = new ArrayList<Product>();
	
	public Category() {
		
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public void internalAddProduct(Product product) {
		this.products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}		
}
