package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id @GeneratedValue
	private long id;
	
	private long parentCat;
	private String catName;
	
	public Category() {
		
	}
	
	public Category(long id, long parentCat, String catName) {
		super();
		this.id = id;
		this.parentCat = parentCat;
		this.catName = catName;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getParentCat() {
		return parentCat;
	}
	
	public void setParentCat(long parentCat) {
		this.parentCat = parentCat;
	}
	
	public String getCatName() {
		return catName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}		
}
