package com.bits.bitscure.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@SequenceGenerator(name = "student_id", sequenceName = "student_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_age")
    private int age;


    @Column(name = "student_contact")
    private String contactNumber;

    @Column(name = "student_email")
    private String email;
    
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Appointment> bookedSlots;

	public Student(Long studentId, String studentName, int age, String contactNumber, String email,
			List<Appointment> bookedSlots) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.contactNumber = contactNumber;
		this.email = email;
		this.bookedSlots = bookedSlots;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getBookedSlots() {
		return bookedSlots;
	}

	public void setBookedSlots(List<Appointment> bookedSlots) {
		this.bookedSlots = bookedSlots;
	}
    
     
}

