package com.bits.bitscure.entities;

import java.util.List;

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

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "student")
    private List<Appointment> bookedSlots;

	public Student(Long studentId, String name, int age, String gender, String contactNumber, String email,
			List<Appointment> bookedSlots) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.bookedSlots = bookedSlots;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

