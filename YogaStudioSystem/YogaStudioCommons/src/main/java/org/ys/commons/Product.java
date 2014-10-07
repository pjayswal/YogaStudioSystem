package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @GeneratedValue
	private long Id;
	
	private int catID;
	private String name;
	

}
