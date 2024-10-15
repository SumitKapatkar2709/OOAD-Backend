package com.bits.bitscure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.entities.Doctors;
import com.bits.bitscure.service.DoctorService;

@RestController
public class DoctorController {

	private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctors> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
	
}
