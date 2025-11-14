package com.healthcare_application.HealthCare.appointment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare_application.HealthCare.appointment.entity.Appointment;
import com.healthcare_application.HealthCare.appointment.entity.Slot;
import com.healthcare_application.HealthCare.appointment.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController 
{


	private final AppointmentService appointmentService;


	public AppointmentController(AppointmentService appointmentService) 
	{
		this.appointmentService = appointmentService;
	}


	@GetMapping
	public List<Appointment> getAllAppointments() 
	{
		return appointmentService.getAllAppointments();
	}


	@PostMapping("/book/{slotId}")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment, @PathVariable Long slotId) 
	{
		return ResponseEntity.ok(appointmentService.bookAppointment(appointment, slotId));
	}


	@GetMapping("/slots/{doctorId}")
	public List<Slot> getAvailableSlots(@PathVariable Long doctorId) 
	{
		return appointmentService.getAvailableSlots(doctorId);
	}
}