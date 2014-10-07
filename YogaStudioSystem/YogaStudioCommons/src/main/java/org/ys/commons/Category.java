package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id @GeneratedValue
	private long Id;
	
	private int parentCat;
	private String catName;	
}
