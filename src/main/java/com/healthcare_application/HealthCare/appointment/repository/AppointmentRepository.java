package com.healthcare_application.HealthCare.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare_application.HealthCare.appointment.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> 
{
	List<Appointment> findByDoctorId(Long doctorId);
}
