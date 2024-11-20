package com.bits.bitscure.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.entities.Doctor;
import com.bits.bitscure.repository.AppointmentRepository;
import com.bits.bitscure.repository.DoctorRepository;
import com.bits.bitscure.service.DoctorService;

import jakarta.transaction.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
    private  DoctorRepository doctorRepository;
	
	@Autowired
    private AppointmentRepository appointmentRepository;


    @Override
    public List<Doctor> getAllDoctors() {
    	return doctorRepository.findByIsVerifiedTrue();
    }
    
    @Override
	public List<Doctor> getAllUnverifiedDoctors() {
    	return doctorRepository.findByIsVerifiedFalse();		 
	}
    
    @Override
    public Doctor getDoctorsById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);

        return doctor.orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }
    
    
    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
    
    @Override
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);

        if (existingDoctor.isPresent()) {
            Doctor doctor = existingDoctor.get();
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
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    
    @Transactional
    public void generateSlotsForDoctor(Doctor doctor) {
        // Delete existing slots for this doctor
        appointmentRepository.deleteByDoctor(doctor);

        // Get today's date and initialize start and end times
        LocalDate today = LocalDate.now();
        LocalDateTime startTime = LocalDateTime.of(today, doctor.getDutyStartTime());
        LocalDateTime endTime = LocalDateTime.of(today, doctor.getDutyEndTime());

        // Get break times with today's date
        LocalDateTime breakStart = doctor.getBreakStartTime() != null
            ? LocalDateTime.of(today, doctor.getBreakStartTime())
            : null;
        LocalDateTime breakEnd = doctor.getBreakEndTime() != null
            ? LocalDateTime.of(today, doctor.getBreakEndTime())
            : null;

        // Check if today is a holiday
        String holiday = doctor.getHoliday();
        if (holiday != null && today.getDayOfWeek().toString().equalsIgnoreCase(holiday)) {
            return; // Skip slot generation on holidays
        }

        List<Appointment> slots = new ArrayList<>();

        // Generate 30-minute slots
        while (startTime.plusMinutes(30).isBefore(endTime) || startTime.plusMinutes(30).equals(endTime)) {
            // Skip slots during break time
            if (breakStart != null && startTime.isBefore(breakEnd) && startTime.plusMinutes(30).isAfter(breakStart)) {
                startTime = breakEnd; // Move to the end of the break
                continue;
            }

            // Create a new slot
            LocalDateTime slotEndTime = startTime.plusMinutes(30);
            Appointment slot = new Appointment();
            slot.setAppointmentStartTime(startTime);
            slot.setAppointmentEndTime(slotEndTime);
            slot.setDoctor(doctor);
            slot.setAvailable(true);

            slots.add(slot);
            startTime = slotEndTime; // Move to the next slot
        }

        // Save all slots
        appointmentRepository.saveAll(slots);
    }

    /**
     * Save or update doctor and regenerate slots.
     */
    @Transactional
    @Override
    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        if (doctor.getDoctorId() != null) {
            Optional<Doctor> existingDoctor = doctorRepository.findById(doctor.getDoctorId());
            if (existingDoctor.isPresent()) {
                // Update the existing doctor
                Doctor updatedDoctor = existingDoctor.get();
                updatedDoctor.setName(doctor.getName());
                updatedDoctor.setAge(doctor.getAge());
                updatedDoctor.setSpecialization(doctor.getSpecialization());
                updatedDoctor.setDoctorAddress(doctor.getDoctorAddress());
                updatedDoctor.setYearsOfExperience(doctor.getYearsOfExperience());
                updatedDoctor.setHoliday(doctor.getHoliday());
                updatedDoctor.setBreakStartTime(doctor.getBreakStartTime());
                updatedDoctor.setBreakEndTime(doctor.getBreakEndTime());
                updatedDoctor.setDutyStartTime(doctor.getDutyStartTime());
                updatedDoctor.setDutyEndTime(doctor.getDutyEndTime());
                updatedDoctor.setIsVerified(doctor.getIsVerified());
                
                // Save and regenerate slots
                doctorRepository.save(updatedDoctor);
                generateSlotsForDoctor(updatedDoctor);
                return updatedDoctor;
            }
        }
        // Create a new doctor if ID is not present
        Doctor savedDoctor = doctorRepository.save(doctor);
        generateSlotsForDoctor(savedDoctor);
        return savedDoctor;
    }
    
    
    @Override
    public void verifyDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();
        doctor.setIsVerified(true);
        doctorRepository.save(doctor);
    }


}
