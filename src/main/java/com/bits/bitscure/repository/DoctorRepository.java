package com.bits.bitscure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.bitscure.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByIsVerifiedTrue();
	
	List<Doctor> findByIsVerifiedFalse();
	
	
}
