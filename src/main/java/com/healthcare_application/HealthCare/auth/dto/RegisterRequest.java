package com.healthcare_application.HealthCare.auth.dto;

public record RegisterRequest(
String username,
String email,
String password,
String role
) {}
