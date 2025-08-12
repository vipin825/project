package com.careflow.cms.service;

import com.careflow.cms.dto.DoctorDTO;
import com.careflow.cms.exception.DoctorNotFoundException;
import com.careflow.cms.model.Doctor;
import com.careflow.cms.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public DoctorDTO create(DoctorDTO doctorDTO){
        Doctor doctor = mapper.map(doctorDTO,Doctor.class);
        Doctor saved = doctorRepository.save(doctor);

        return mapper.map(saved,DoctorDTO.class );
    }

    public List<DoctorDTO> getAll(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> mapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public DoctorDTO update(Long id, DoctorDTO doctorDTO){
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));

        existing.setFirstName(doctorDTO.getFirstName());
        existing.setLastName(doctorDTO.getLastName());
        existing.setSpecialty(doctorDTO.getSpecialty());
        existing.setPhoneNumber(doctorDTO.getPhoneNumber());
        existing.setEmail(doctorDTO.getEmail());

        return mapper.map(doctorRepository.save(existing), DoctorDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        doctorRepository.delete(doctor);
    }

    public DoctorDTO getById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        return mapper.map(doctor, DoctorDTO.class);
    }
}
