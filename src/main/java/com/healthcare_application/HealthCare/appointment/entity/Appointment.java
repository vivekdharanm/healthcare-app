package com.healthcare_application.HealthCare.appointment.entity;

import java.time.LocalTime;

import com.healthcare_application.HealthCare.doctor.entity.Doctor;

import co.elastic.clients.elasticsearch.security.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment 
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	private User user;


	@ManyToOne
	private Doctor doctor;

	private LocalTime appointmentTime;

    // getter
    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    // setter
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

	
	private String status;
}
