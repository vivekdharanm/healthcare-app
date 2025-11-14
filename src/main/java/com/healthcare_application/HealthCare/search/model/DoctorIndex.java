package com.healthcare_application.HealthCare.search.model;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "doctors")
@Getter
@Setter
public class DoctorIndex 
{


	@Id
	private String id;
	private String name;
	private String specialty;
	private String email;
	private String phone;
}