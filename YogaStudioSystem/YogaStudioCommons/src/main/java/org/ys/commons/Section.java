package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Section {
	
	@Id @GeneratedValue
	private long Id;
	
	private Course course;
	private Semester semester;
	private int totalSeat;
	private Faculty faculty;
	private List<Customer> enrolledCustomers = new ArrayList<Customer>();
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
		course.addSection(this);
		semester.addSection(this);
		faculty.addTakingSection(this);
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
	}

	public List<Customer> getWaitingListCustomers() {
		return waitingListCustomers;
	}

	public void addWaitingListCustomers(Customer customer) {
		waitingListCustomers.add(customer);
	}

	public long getId() {
		return Id;
	}	
}
