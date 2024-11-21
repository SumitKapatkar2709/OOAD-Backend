package com.bits.bitscure.DTO.response;


import java.time.LocalTime;
import java.util.List;

import com.bits.bitscure.entities.Appointment;

public class DoctorResponseDTO {
    
	private Long doctorId;
    private String doctorName;
    private int doctorAge;
    private String specialization;
    private String doctorAddress;
    private int yearsOfExperience;
    private String holiday;
    private Boolean isVerified;
    private LocalTime breakStartTime;
    private LocalTime breakEndTime;
    private LocalTime dutyStartTime;
    private LocalTime dutyEndTime;
    private List<Appointment> slots;
	public DoctorResponseDTO(Long doctorId, String doctorName, int doctorAge, String specialization,
			String doctorAddress, int yearsOfExperience, String holiday, Boolean isVerified, LocalTime breakStartTime,
			LocalTime breakEndTime, LocalTime dutyStartTime, LocalTime dutyEndTime, List<Appointment> slots) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorAge = doctorAge;
		this.specialization = specialization;
		this.doctorAddress = doctorAddress;
		this.yearsOfExperience = yearsOfExperience;
		this.holiday = holiday;
		this.isVerified = isVerified;
		this.breakStartTime = breakStartTime;
		this.breakEndTime = breakEndTime;
		this.dutyStartTime = dutyStartTime;
		this.dutyEndTime = dutyEndTime;
		this.slots = slots;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
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
	public List<Appointment> getSlots() {
		return slots;
	}
	public void setSlots(List<Appointment> slots) {
		this.slots = slots;
	}
    
    
	
	
    
    
    
   
}

