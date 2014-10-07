package org.ys.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester {
	
	
	@Id @GeneratedValue
	private long Id;
	
	private String semesterName;

	public Semester(long id, String semesterName) {
		this.Id = id;
		this.semesterName = semesterName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	
	
}
