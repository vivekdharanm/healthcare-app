package com.healthcare_application.HealthCare.doctor.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare_application.HealthCare.doctor.entity.Doctor;
import com.healthcare_application.HealthCare.doctor.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController 
{


	private final DoctorService doctorService;


	public DoctorController(DoctorService doctorService) 
	{
		this.doctorService = doctorService;
	}


	@GetMapping
	public List<Doctor> getAllDoctors() 
	{
		return doctorService.getAllDoctors();
	}


	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) 
	{
		Doctor doctor = doctorService.getDoctorById(id);
		return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
	}


	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) 
	{
		return doctorService.saveDoctor(doctor);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) 
	{
		Doctor doctor = doctorService.getDoctorById(id);
		if (doctor != null) 
		{
			doctor.setName(updatedDoctor.getName());
			doctor.setSpecialty(updatedDoctor.getSpecialty());
			doctor.setEmail(updatedDoctor.getEmail());
			doctor.setPhone(updatedDoctor.getPhone());
			return ResponseEntity.ok(doctorService.saveDoctor(doctor));
		}
		return ResponseEntity.notFound().build();
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) 
	{
		doctorService.deleteDoctor(id);
		return ResponseEntity.ok().build();
	}
}
