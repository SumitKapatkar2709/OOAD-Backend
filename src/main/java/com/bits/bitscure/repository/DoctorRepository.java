package com.bits.bitscure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.bitscure.entities.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {
    // JpaRepository provides basic CRUD methods
}
