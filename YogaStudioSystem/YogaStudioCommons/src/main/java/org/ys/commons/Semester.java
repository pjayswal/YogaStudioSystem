package org.ys.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Semester {
	
	
	@Id @GeneratedValue
	private long id;
	
	private String name;
	private String description;
	@OneToMany(mappedBy="semester")
	private List<Section> sections = new ArrayList<Section>();
	@Temporal(TemporalType.DATE)
	private Date dateFrom;
	@Temporal(TemporalType.DATE)
	private Date dateTo;
	
	public Semester() {
		// TODO Auto-generated constructor stub
	}
	
	public Semester(String name, String description,
			Date dateFrom, Date dateTo) {
		super();
		this.name = name;
		this.description = description;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
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
	public List<Section> getSections() {
		return sections;
	}
	public void addSection(Section section) {
		this.sections.add(section);
	}
	public long getId() {
		return id;
	}	
}
