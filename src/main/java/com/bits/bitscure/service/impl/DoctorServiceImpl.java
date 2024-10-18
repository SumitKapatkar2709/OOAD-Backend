package com.bits.bitscure.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.bitscure.entities.Doctors;
import com.bits.bitscure.repository.DoctorRepository;
import com.bits.bitscure.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
    private  DoctorRepository doctorRepository;


    @Override
    public List<Doctors> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    @Override
    public Doctors getDoctorsById(Long id) {
        Optional<Doctors> doctor = doctorRepository.findById(id);

        return doctor.orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }
    
    
    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
    
    @Override
    public Doctors updateDoctor(Long id, Doctors updatedDoctor) {
        Optional<Doctors> existingDoctor = doctorRepository.findById(id);

        if (existingDoctor.isPresent()) {
            Doctors doctor = existingDoctor.get();
            doctor.setName(updatedDoctor.getName());
            doctor.setAge(updatedDoctor.getAge());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setDoctorAddress(updatedDoctor.getDoctorAddress());
            doctor.setYearsOfExperience(updatedDoctor.getYearsOfExperience());
            return doctorRepository.save(doctor);
        } else {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
    }
    
    @Override
    public Doctors addDoctor(Doctors doctor) {
        return doctorRepository.save(doctor);
    }
}
