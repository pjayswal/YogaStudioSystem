package org.ys.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Section {
	
	@Id @GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="course_id")
	@NotNull(message="course is required")
	private Course course;
	@ManyToOne
	private Semester semester;
	@Min(value=10,message="minimum seat require is 10")
	private int totalSeat;
	@ManyToOne
	@NotNull(message="faculty is required")
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
		if(this.faculty!=null){
			this.faculty.getTakingSections().remove(this);
		}
		this.faculty = faculty;
		faculty.internalAddTakingSection(this);
		
	}

	public String getName() {
		return course.getName();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		if(this.course!=null){
			this.course.getSections().remove(this);
		}
		this.course = course;
		course.internalAddSection(this);
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		if(this.semester!=null)
			this.semester.getSections().remove(this);
		this.semester = semester;
		semester.internalAddSection(this);
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
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return course.getName()+":"+faculty.getName();
	}
	
	public int getAvailSeats(){
		return totalSeat-enrolledCustomers.size();
	}
}
