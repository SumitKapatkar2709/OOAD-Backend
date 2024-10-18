package com.bits.bitscure.service;

import java.util.List;

import com.bits.bitscure.entities.Doctors;

public interface DoctorService {
    List<Doctors> getAllDoctors();

    Doctors getDoctorsById(Long id);
    
    void deleteDoctorById(Long id);
    
    Doctors updateDoctor(Long id, Doctors updatedDoctor);
    
    Doctors addDoctor(Doctors doctor);
}
