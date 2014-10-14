package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Section {
	
	@Id @GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	@ManyToOne
	private Semester semester;
	private int totalSeat;
	@ManyToOne
	private Faculty faculty;
	@ManyToMany(mappedBy="enrolledSections")
	private List<Customer> enrolledCustomers = new ArrayList<Customer>();
	@ManyToMany(mappedBy="waitListSections")
	private List<Customer> waitingListCustomers = new ArrayList<Customer>();
	
	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(Course course, Semester semester, int totalSeat, Faculty faculty) {
		super();

		this.course = course;
		this.semester = semester;
		this.totalSeat = totalSeat;
		this.faculty = faculty;
		course.internalAddSection(this);
		semester.internalAddSection(this);
		faculty.internalAddTakingSection(this);
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getName() {
		return course.getName();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public List<Customer> getEnrolledCustomers() {
		return enrolledCustomers;
	}

	public void addEnrolledCustomers(Customer customer) {
		enrolledCustomers.add(customer);
		customer.internalAddEnrolledSection(this);
	}

	public List<Customer> getWaitingListCustomers() {
		return waitingListCustomers;
	}

	public void addWaitingListCustomers(Customer customer) {
		waitingListCustomers.add(customer);
		customer.internalAddWaitListSections(this);
	}

	public long getId() {
		return id;
	}	
}
