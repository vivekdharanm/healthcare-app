package com.healthcare_application.HealthCare.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare_application.HealthCare.doctor.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> 
{
	
}
