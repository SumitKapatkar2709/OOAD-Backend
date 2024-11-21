package com.bits.bitscure.DTO.response;

import java.time.LocalDateTime;
import java.util.List;

public class StudentResponseDTO {
    private Long studentId;
    private String studentName;
    private int studentAge;
    private String studentContactNumber;
    private String studentEmail;

    private List<SlotDoctorDetails> slots;

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentContactNumber() {
        return studentContactNumber;
    }

    public void setStudentContactNumber(String studentContactNumber) {
        this.studentContactNumber = studentContactNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public List<SlotDoctorDetails> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDoctorDetails> slots) {
        this.slots = slots;
    }

    // Inner Class for SlotDoctorDetails
    public static class SlotDoctorDetails {
        private Long slotId;
        private LocalDateTime appointmentStartTime;
        private LocalDateTime appointmentEndTime;
        private boolean available;

        private Long doctorId;
        private String doctorName;
        private int doctorAge;
        private String specialization;
        private String doctorAddress;
        private int yearsOfExperience;

        // Getters and Setters
        public Long getSlotId() {
            return slotId;
        }

        public void setSlotId(Long slotId) {
            this.slotId = slotId;
        }

        public LocalDateTime getAppointmentStartTime() {
            return appointmentStartTime;
        }

        public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
            this.appointmentStartTime = appointmentStartTime;
        }

        public LocalDateTime getAppointmentEndTime() {
            return appointmentEndTime;
        }

        public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
            this.appointmentEndTime = appointmentEndTime;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public Long getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(Long doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public int getDoctorAge() {
            return doctorAge;
        }

        public void setDoctorAge(int doctorAge) {
            this.doctorAge = doctorAge;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }

        public String getDoctorAddress() {
            return doctorAddress;
        }

        public void setDoctorAddress(String doctorAddress) {
            this.doctorAddress = doctorAddress;
        }

        public int getYearsOfExperience() {
            return yearsOfExperience;
        }

        public void setYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }
}
