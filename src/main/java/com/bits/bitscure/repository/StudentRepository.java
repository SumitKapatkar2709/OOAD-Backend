package com.bits.bitscure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.bitscure.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByStudentName(String name);
	
}

