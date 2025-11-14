package com.healthcare_application.HealthCare.prescription.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare_application.HealthCare.prescription.entity.Prescription;
import com.healthcare_application.HealthCare.prescription.service.PrescriptionService;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController 
{


	private final PrescriptionService prescriptionService;


	public PrescriptionController(PrescriptionService prescriptionService) 
	{
		this.prescriptionService = prescriptionService;
	}


	@GetMapping
	public List<Prescription> getAllPrescriptions() 
	{
		return prescriptionService.getAllPrescriptions();
	}


	@PostMapping
	public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) 
	{
		return ResponseEntity.ok(prescriptionService.createPrescription(prescription));
	}
}
