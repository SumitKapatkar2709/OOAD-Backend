package com.bits.bitscure.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "appointment")
public class Appointment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long appointmentId;

	    private LocalDateTime appointmentStartTime;
	    private LocalDateTime appointmentEndTime;

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    @JsonIgnore
	    private Doctor doctor;  

	    @ManyToOne
	    @JoinColumn(name = "student_id")

	    private Student student;  

	    private boolean isAvailable;
	    
	    private String details;
	    private String diagnosis;
	    private String prescription;


		public Appointment(Long appointmentId, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime,
				Doctor doctor, Student student, boolean isAvailable, String details, String diagnosis,
				String prescription) {
			super();
			this.appointmentId = appointmentId;
			this.appointmentStartTime = appointmentStartTime;
			this.appointmentEndTime = appointmentEndTime;
			this.doctor = doctor;
			this.student = student;
			this.isAvailable = isAvailable;
			this.details = details;
			this.diagnosis = diagnosis;
			this.prescription = prescription;
		}

		public Appointment() {
			super();
			// TODO Auto-generated constructor stub
		}

				public Long getAppointmentId() {
			return appointmentId;
		}



		public void setAppointmentId(Long appointmentId) {
			this.appointmentId = appointmentId;
		}



		public LocalDateTime getAppointmentStartTime() {
			return appointmentStartTime;
		}

		public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
			this.appointmentStartTime = appointmentStartTime;
		}

		public LocalDateTime getAppointmentEndTime() {
			return appointmentEndTime;
		}

		public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
			this.appointmentEndTime = appointmentEndTime;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public String getDiagnosis() {
			return diagnosis;
		}

		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}

		public String getPrescription() {
			return prescription;
		}

		public void setPrescription(String prescription) {
			this.prescription = prescription;
		}
    
	    
}
