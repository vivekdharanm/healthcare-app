package com.healthcare_application.HealthCare.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.doctor.entity.Doctor;
import com.healthcare_application.HealthCare.doctor.repository.DoctorRepository;

@Service
public class DoctorService 
{


	private final DoctorRepository doctorRepository;


	public DoctorService(DoctorRepository doctorRepository) 
	{
		this.doctorRepository = doctorRepository;
	}


	public List<Doctor> getAllDoctors() 
	{
		return doctorRepository.findAll();
	}


	public Doctor getDoctorById(Long id) 
	{
		return doctorRepository.findById(id).orElse(null);
	}


	public Doctor saveDoctor(Doctor doctor) 
	{
		return doctorRepository.save(doctor);
	}


	public void deleteDoctor(Long id) 
	{
		doctorRepository.deleteById(id);
	}
}
