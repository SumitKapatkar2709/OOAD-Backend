package com.bits.bitscure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.entities.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	void deleteByDoctor(Doctor doctor);}

