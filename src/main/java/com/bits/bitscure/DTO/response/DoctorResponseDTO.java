package com.bits.bitscure.DTO.response;


import java.time.LocalTime;

public class DoctorResponseDTO {
    
	private Long doctorId;
    private String name;
    private int age;
    private String specialization;
    private String doctorAddress;
    private int yearsOfExperience;
    private String holiday;
    private Boolean isVerified;
    private LocalTime breakStartTime;
    private LocalTime breakEndTime;
    private LocalTime dutyStartTime;
    private LocalTime dutyEndTime;
	public DoctorResponseDTO(Long doctorId, String name, int age, String specialization, String doctorAddress,
			int yearsOfExperience, String holiday, Boolean isVerified, LocalTime breakStartTime, LocalTime breakEndTime,
			LocalTime dutyStartTime, LocalTime dutyEndTime) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.doctorAddress = doctorAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.holiday = holiday;
		this.isVerified = isVerified;
		this.breakStartTime = breakStartTime;
		this.breakEndTime = breakEndTime;
		this.dutyStartTime = dutyStartTime;
		this.dutyEndTime = dutyEndTime;
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
	public Boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
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
    
    
   
}

