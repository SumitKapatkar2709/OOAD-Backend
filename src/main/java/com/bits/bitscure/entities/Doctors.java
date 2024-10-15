package com.bits.bitscure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctors {
	
	@Column(name = "doctor_id")
	@Id
	@SequenceGenerator(name = "rating_seq", sequenceName = "rating_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
	private Long doctorId;
	
	@Column(name = "doctor_name")  
    private String name;
    
    @Column(name = "doctor_age")  
    private int age;
    
    @Column(name = "specialization")  
    private String specialization;
    
    @Column(name = "doctor_address")  
    private String doctorAddress;
    
    @Column(name = "years_of_experience")  
    private int yearsOfExperience;

	public Doctors(Long doctorId, String name, int age, String specialization, String doctorAddress,
			int yearsOfExperience) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.doctorAddress = doctorAddress;
		this.yearsOfExperience = yearsOfExperience;
	}

	public Doctors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
    
    
}
