package com.bits.bitscure.service;

import java.util.List;

import com.bits.bitscure.entities.Doctor;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Doctor getDoctorsById(Long id);
    
    void deleteDoctorById(Long id);
    
    Doctor updateDoctor(Long id, Doctor updatedDoctor);
    
    Doctor addDoctor(Doctor doctor);

	Doctor saveOrUpdateDoctor(Doctor doctor);
    
    
    
}
