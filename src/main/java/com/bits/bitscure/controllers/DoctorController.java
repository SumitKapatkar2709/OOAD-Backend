package com.bits.bitscure.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.DTO.response.DoctorResponseDTO;
import com.bits.bitscure.entities.Doctor;
import com.bits.bitscure.service.DoctorService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class DoctorController {

	private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<DoctorResponseDTO> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        
        // Convert list of Doctor entities to list of DoctorResponseDTOs
        List<DoctorResponseDTO> doctorResponseDTOs = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO(
            		doctor.getDoctorId(),
            	    doctor.getDoctorName(),
            	    doctor.getAge(),
            	    doctor.getSpecialization(),
            	    doctor.getDoctorAddress(),
            	    doctor.getYearsOfExperience(),
            	    doctor.getHoliday(),
            	    doctor.getIsVerified(),
            	    doctor.getBreakStartTime(),
            	    doctor.getBreakEndTime(),
            	    doctor.getDutyStartTime(),
            	    doctor.getDutyEndTime(),
            	    doctor.getSlots()
            );
            doctorResponseDTOs.add(doctorResponseDTO);
        }
        
        return doctorResponseDTOs;
    }
    
    @GetMapping("/doctors/unverified")
    public List<DoctorResponseDTO> getAllUnverifiedDoctors() {
        List<Doctor> doctors = doctorService.getAllUnverifiedDoctors();
        
        // Convert list of Doctor entities to list of DoctorResponseDTOs
        List<DoctorResponseDTO> doctorResponseDTOs = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO(
            		doctor.getDoctorId(),
            	    doctor.getDoctorName(),
            	    doctor.getAge(),
            	    doctor.getSpecialization(),
            	    doctor.getDoctorAddress(),
            	    doctor.getYearsOfExperience(),
            	    doctor.getHoliday(),
            	    doctor.getIsVerified(),
            	    doctor.getBreakStartTime(),
            	    doctor.getBreakEndTime(),
            	    doctor.getDutyStartTime(),
            	    doctor.getDutyEndTime(),
            	    doctor.getSlots()
            );
            doctorResponseDTOs.add(doctorResponseDTO);
        }
        
        return doctorResponseDTOs;
    }
    
    

    
    @GetMapping("/doctors/{id}")
    public DoctorResponseDTO getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorsById(id);
        
        // Convert Doctor entity to DoctorResponseDTO
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO(
        		doctor.getDoctorId(),
        	    doctor.getDoctorName(),
        	    doctor.getAge(),
        	    doctor.getSpecialization(),
        	    doctor.getDoctorAddress(),
        	    doctor.getYearsOfExperience(),
        	    doctor.getHoliday(),
        	    doctor.getIsVerified(),
        	    doctor.getBreakStartTime(),
        	    doctor.getBreakEndTime(),
        	    doctor.getDutyStartTime(),
        	    doctor.getDutyEndTime(),
        	    doctor.getSlots()
        );
        
        return doctorResponseDTO;
    }

    
    @DeleteMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }
    
    @PutMapping("/doctors/verify/{id}")
    public ResponseEntity<String> verifyDoctor(@PathVariable Long id) {
        doctorService.verifyDoctor(id);
        return ResponseEntity.ok("Doctor with ID " + id + " has been verified.");
    }
    
//    @PutMapping("/doctors/{id}")
//    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
//        return doctorService.updateDoctor(id, doctor);
//    }
    
//    @PostMapping("/doctors")
//    public Doctor addDoctor(@RequestBody Doctor doctor) {
//        return doctorService.addDoctor(doctor);
//    }
    
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addOrUpdateDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveOrUpdateDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
	
}
