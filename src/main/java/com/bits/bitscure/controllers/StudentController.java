package com.bits.bitscure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.DTO.response.StudentResponseDTO;
import com.bits.bitscure.service.StudentService;


@CrossOrigin(origins = "", allowedHeaders = "", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class StudentController {

	    @Autowired
	    private StudentService studentService;
	    
	    @GetMapping("/students")
	    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
	        List<StudentResponseDTO> allStudents = studentService.getAllStudentsWithSlotsAndDoctors();
	        return ResponseEntity.ok(allStudents);
	    }

	    // Get all students with slots
	    @GetMapping("/students/{id}")
	    public ResponseEntity<StudentResponseDTO> getStudentDetails(@PathVariable Long id) {
	        StudentResponseDTO response = studentService.getStudentDetailsWithSlots(id);
	        return ResponseEntity.ok(response);
	    }

	    // Get a student by ID with slots
//	   
	}
