package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	@Id @GeneratedValue
	private long Id;
	
	private String code;
	private String name;	
	private String description;
	
	private List<Course> prerequisites= new ArrayList<Course>();
	private List<Section> sections = new ArrayList<Section>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public void addPrerequisites(Course prerequisite){
		this.prerequisites.add(prerequisite);
	}
	
	public void addSection(Section section){
		sections.add(section);
		
	}
	
	public long getId() {
		return Id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
	
}