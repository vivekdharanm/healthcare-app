package com.healthcare_application.HealthCare.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.appointment.entity.Appointment;
import com.healthcare_application.HealthCare.appointment.entity.Slot;
import com.healthcare_application.HealthCare.appointment.repository.AppointmentRepository;
import com.healthcare_application.HealthCare.appointment.repository.SlotRepository;

@Service
public class AppointmentService 
{


	private final AppointmentRepository appointmentRepository;
	private final SlotRepository slotRepository;


	public AppointmentService(AppointmentRepository appointmentRepository, SlotRepository slotRepository) 
	{
		this.appointmentRepository = appointmentRepository;
		this.slotRepository = slotRepository;
	}


	public List<Appointment> getAllAppointments() 
	{
		return appointmentRepository.findAll();
	}


	public Appointment bookAppointment(Appointment appointment, Long slotId) 
	{
		Slot slot = slotRepository.findById(slotId).orElseThrow();
		if (!slot.isBooked()) 
		{
			slot.setBooked(true);
			appointment.setAppointmentTime(slot.getStartTime());
			slotRepository.save(slot);
			return appointmentRepository.save(appointment);
		}
		throw new RuntimeException("Slot already booked");
	}


	public List<Slot> getAvailableSlots(Long doctorId) 
	{
		return slotRepository.findByDoctorIdAndBookedFalse(doctorId);
	}
}