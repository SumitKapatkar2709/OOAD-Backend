package com.bits.bitscure.service.impl;

import com.bits.bitscure.entities.Doctors;
import com.bits.bitscure.repository.DoctorRepository;
import com.bits.bitscure.service.DoctorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctors> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
