package com.bits.bitscure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.entities.Doctors;
import com.bits.bitscure.service.DoctorService;

@RestController
public class DoctorController {

	private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/doctors")
    public List<Doctors> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    
    @DeleteMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // Returns 204 No Content if successful
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }
    
    @PutMapping("/doctors/{id}")
    public Doctors updateDoctor(@PathVariable Long id, @RequestBody Doctors doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
	
}
