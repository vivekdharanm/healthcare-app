package com.healthcare_application.HealthCare.prescription.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.prescription.entity.Prescription;
import com.healthcare_application.HealthCare.prescription.pdf.PdfGenerator;

@Service
public class PrescriptionService 
{


	private final PrescriptionRepository prescriptionRepository;
	private final PdfGenerator pdfGenerator;


	public PrescriptionService(PrescriptionRepository prescriptionRepository, PdfGenerator pdfGenerator) 
	{
		this.prescriptionRepository = prescriptionRepository;
		this.pdfGenerator = pdfGenerator;
	}


	public List<Prescription> getAllPrescriptions() 
	{
		return prescriptionRepository.findAll();
	}


	public Prescription createPrescription(Prescription prescription) 
	{
		Prescription saved = prescriptionRepository.save(prescription);
		pdfGenerator.generatePdf(saved);
		return saved;
	}
}
