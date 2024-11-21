package com.bits.bitscure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    public boolean updateAppointmentDetails(Long appointmentId, String details, String diagnosis, String prescription) {
        int rowsUpdated = appointmentRepository.updateAppointmentDetails(appointmentId, details, diagnosis, prescription);
        return rowsUpdated > 0;
    }
}
