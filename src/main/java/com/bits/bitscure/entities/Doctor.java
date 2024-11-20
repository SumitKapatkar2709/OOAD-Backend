package com.bits.bitscure.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
//@EntityListeners(DoctorEntityListener.class)
@Table(name = "doctor")
public class Doctor {
	
	@Column(name = "doctor_id")
	@Id
	@SequenceGenerator(name = "doctor_id", sequenceName = "doctor_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_id")
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
    
    @Column(name = "holiday")
    private String holiday; // Store as a string, e.g., "Monday", "Tuesday", etc.

    @Column(name = "break_start_time")
    private LocalTime breakStartTime;

    @Column(name = "break_end_time")
    private LocalTime breakEndTime;

    @Column(name = "duty_start_time")
    private LocalTime dutyStartTime;

    @Column(name = "duty_end_time")
    private LocalTime dutyEndTime;
    
    @Column(name = "is_verified")
    private Boolean isVerified;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> slots;

	public Doctor(Long doctorId, String name, int age, String specialization, String doctorAddress,
			int yearsOfExperience, String holiday, LocalTime breakStartTime, LocalTime breakEndTime,
			LocalTime dutyStartTime, LocalTime dutyEndTime, Boolean isVerified, List<Appointment> slots) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.doctorAddress = doctorAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.holiday = holiday;
		this.breakStartTime = breakStartTime;
		this.breakEndTime = breakEndTime;
		this.dutyStartTime = dutyStartTime;
		this.dutyEndTime = dutyEndTime;
		this.isVerified = isVerified;
		this.slots = slots;
	}
	
	

	public Doctor() {
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

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public LocalTime getBreakStartTime() {
		return breakStartTime;
	}

	public void setBreakStartTime(LocalTime breakStartTime) {
		this.breakStartTime = breakStartTime;
	}

	public LocalTime getBreakEndTime() {
		return breakEndTime;
	}

	public void setBreakEndTime(LocalTime breakEndTime) {
		this.breakEndTime = breakEndTime;
	}

	public LocalTime getDutyStartTime() {
		return dutyStartTime;
	}

	public void setDutyStartTime(LocalTime dutyStartTime) {
		this.dutyStartTime = dutyStartTime;
	}

	public LocalTime getDutyEndTime() {
		return dutyEndTime;
	}

	public void setDutyEndTime(LocalTime dutyEndTime) {
		this.dutyEndTime = dutyEndTime;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public List<Appointment> getSlots() {
		return slots;
	}

	public void setSlots(List<Appointment> slots) {
		this.slots = slots;
	}

	
    
	
    
}
