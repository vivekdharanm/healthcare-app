package com.healthcare_application.HealthCare.appointment.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.healthcare_application.HealthCare.doctor.entity.Doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "slots")
@Getter
@Setter
public class Slot 
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	private Doctor doctor;
	
	private boolean booked;  // example field

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    private LocalTime startTime;// this stores the slot's start time

    // getter
    public LocalTime getStartTime() {
        return startTime;
    }

    // setter
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }


	
	private LocalDateTime endTime;
}
