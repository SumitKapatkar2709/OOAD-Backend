package com.bits.bitscure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bits.bitscure.DTO.response.StudentResponseDTO;
import com.bits.bitscure.entities.Student;
import com.bits.bitscure.service.StudentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
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

	    @PutMapping("/students/add")
	    public ResponseEntity<String> assignStudentToAppointment(@RequestParam Long appointmentId, @RequestParam Long studentId) {
	        boolean isUpdated = studentService.assignStudentToAppointment(appointmentId, studentId);
	        
	        if(isUpdated) {
	            return ResponseEntity.ok("Student assigned to appointment successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment or Student not found.");
	        }
	    }
	    
	    @GetMapping("/api/students/me")
	    public ResponseEntity<Student> getAuthenticatedStudent(Authentication authentication) {
	        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
	        String email = oAuth2User.getAttribute("email");

	        // Fetch student by email
	        Student student = studentService.findByEmail(email);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }
	}

