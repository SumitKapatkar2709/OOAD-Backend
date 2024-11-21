package com.bits.bitscure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.entities.Doctor;
import com.bits.bitscure.entities.Student;

import jakarta.transaction.Transactional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	void deleteByDoctor(Doctor doctor);

	Optional<Student> findByAppointmentId(Long appointmentId);
	
	 @Modifying
	    @Transactional
	    @Query("UPDATE Appointment a SET a.student.studentId = :studentId, a.isAvailable = false WHERE a.appointmentId = :appointmentId")
	    void updateStudentForAppointment(@Param("appointmentId") Long appointmentId, @Param("studentId") Long studentId);
	 
	 
	 @Modifying
	    @Transactional
	    @Query("UPDATE Appointment a SET a.details = :details, a.diagnosis = :diagnosis, a.prescription = :prescription WHERE a.appointmentId = :appointmentId")
	    int updateAppointmentDetails(Long appointmentId, String details, String diagnosis, String prescription);
	

}

