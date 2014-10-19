package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty(message="code is required")
	private String code;
	@NotEmpty(message="name is required")
	private String name;
	private String description;

	@ManyToMany
	@JoinTable(name = "prerequisite", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "prerequisite_id") })
	private List<Course> prerequisites = new ArrayList<Course>();
	@OneToMany(mappedBy = "course")
	private List<Section> sections = new ArrayList<Section>();



	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public void addPrerequisites(Course prerequisite) {
		this.prerequisites.add(prerequisite);
	}

	public void internalAddSection(Section section) {
		sections.add(section);

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

	public void setId(long id) {
		this.id = id;
	}
	

}