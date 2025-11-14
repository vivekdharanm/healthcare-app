package com.healthcare_application.HealthCare.prescription.entity;

import java.time.LocalDate;

import com.healthcare_application.HealthCare.appointment.entity.Appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
public class Prescription 
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne
	private Appointment appointment;


	private String diagnosis;
	private String medications;
	private LocalDate date;
}