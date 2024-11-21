package com.bits.bitscure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.bitscure.DTO.response.StudentResponseDTO;
import com.bits.bitscure.DTO.response.StudentResponseDTO.SlotDoctorDetails;
import com.bits.bitscure.entities.Appointment;
import com.bits.bitscure.entities.Doctor;
import com.bits.bitscure.entities.Student;
import com.bits.bitscure.repository.AppointmentRepository;
import com.bits.bitscure.repository.DoctorRepository;
import com.bits.bitscure.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public List<StudentResponseDTO> getAllStudentsWithSlotsAndDoctors() {
        List<Student> students = studentRepository.findAll();  // Fetch all students from the database
        List<StudentResponseDTO> studentResponseList = new ArrayList<>();

        for (Student student : students) {
            // Create response DTO for each student
            StudentResponseDTO responseDTO = new StudentResponseDTO();
            responseDTO.setStudentId(student.getStudentId());
            responseDTO.setStudentName(student.getStudentName());
            responseDTO.setStudentAge(student.getStudentAge());
            responseDTO.setStudentContactNumber(student.getContactNumber());
            responseDTO.setStudentEmail(student.getEmail());

            // Fetch booked slots for the student (assuming `student.getBookedSlots()` provides a list of slots)
            List<SlotDoctorDetails> slotDetails = student.getBookedSlots().stream().map(slot -> {
                SlotDoctorDetails slotDoctorDetails = new SlotDoctorDetails();
                slotDoctorDetails.setSlotId(slot.getAppointmentId());
                slotDoctorDetails.setAppointmentStartTime(slot.getAppointmentStartTime());
                slotDoctorDetails.setAppointmentEndTime(slot.getAppointmentEndTime());
                slotDoctorDetails.setAvailable(slot.isAvailable());

                // Fetch doctor details associated with the slot
                Doctor doctor = slot.getDoctor();
                slotDoctorDetails.setDoctorId(doctor.getDoctorId());
                slotDoctorDetails.setDoctorName(doctor.getName());
                slotDoctorDetails.setDoctorAge(doctor.getAge());
                slotDoctorDetails.setSpecialization(doctor.getSpecialization());
                slotDoctorDetails.setDoctorAddress(doctor.getDoctorAddress());
                slotDoctorDetails.setYearsOfExperience(doctor.getYearsOfExperience());

                return slotDoctorDetails;
            }).collect(Collectors.toList());

            responseDTO.setSlots(slotDetails);

            // Add the student response DTO to the list
            studentResponseList.add(responseDTO);
        }

        return studentResponseList;
    }
    
    public StudentResponseDTO getStudentDetailsWithSlots(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow();

        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setStudentId(student.getStudentId());
        responseDTO.setStudentName(student.getStudentName());
        responseDTO.setStudentAge(student.getStudentAge());
        responseDTO.setStudentContactNumber(student.getContactNumber());
        responseDTO.setStudentEmail(student.getEmail());

        List<SlotDoctorDetails> slotDetails = student.getBookedSlots().stream().map(slot -> {
            SlotDoctorDetails slotDoctorDetails = new SlotDoctorDetails();
            slotDoctorDetails.setSlotId(slot.getAppointmentId());
            slotDoctorDetails.setAppointmentStartTime(slot.getAppointmentStartTime());
            slotDoctorDetails.setAppointmentEndTime(slot.getAppointmentEndTime());
            slotDoctorDetails.setAvailable(slot.isAvailable());

            Doctor doctor = slot.getDoctor();
            slotDoctorDetails.setDoctorId(doctor.getDoctorId());
            slotDoctorDetails.setDoctorName(doctor.getName());
            slotDoctorDetails.setDoctorAge(doctor.getAge());
            slotDoctorDetails.setSpecialization(doctor.getSpecialization());
            slotDoctorDetails.setDoctorAddress(doctor.getDoctorAddress());
            slotDoctorDetails.setYearsOfExperience(doctor.getYearsOfExperience());

            return slotDoctorDetails;
        }).collect(Collectors.toList());

        responseDTO.setSlots(slotDetails);

        return responseDTO;
    }
    
    
    public boolean assignStudentToAppointment(Long appointmentId, Long studentId) {
        // Call the repository method to update the studentId
        try {
            appointmentRepository.updateStudentForAppointment(appointmentId, studentId);
            return true;
        } catch (Exception e) {
            // Handle the case if something goes wrong (e.g., invalid appointmentId or studentId)
            return false;
        }
    }

}

