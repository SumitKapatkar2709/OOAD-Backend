package com.bits.bitscure.service;

import java.util.List;

import com.bits.bitscure.entities.Doctors;

public interface DoctorService {
    List<Doctors> getAllDoctors();
    void deleteDoctorById(Long id);
    
    Doctors updateDoctor(Long id, Doctors updatedDoctor);
}
