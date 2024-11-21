package com.bits.bitscure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.service.AppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // DTO to accept the request body
    public static class UpdateAppointmentRequest {
        public String details;
        public String diagnosis;
        public String prescription;
    }
    
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    // API: Get appointment by ID
    @GetMapping("/appointments/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/appointments/{appointmentId}")
    public ResponseEntity<String> updateAppointmentDetails(
            @PathVariable Long appointmentId,
            @RequestBody UpdateAppointmentRequest request) {

        boolean isUpdated = appointmentService.updateAppointmentDetails(
                appointmentId, 
                request.details, 
                request.diagnosis, 
                request.prescription
        );

        if (isUpdated) {
            return ResponseEntity.ok("Appointment details updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update appointment details. Please check the appointment ID.");
        }
    }
}

