package com.healthcare_application.HealthCare.auth.service;

import org.springframework.stereotype.Service;

import com.healthcare_application.HealthCare.auth.dto.AuthResponse;
import com.healthcare_application.HealthCare.auth.dto.LoginRequest;
import com.healthcare_application.HealthCare.auth.dto.RegisterRequest;
import com.healthcare_application.HealthCare.auth.util.PasswordEncoderUtil;
import com.healthcare_application.HealthCare.config.JwtUtil;
import com.healthcare_application.HealthCare.user.entity.User;
import com.healthcare_application.HealthCare.user.repository.UserRepository;



@Service
public class AuthService 
{


	private final UserRepository userRepository;
	private final PasswordEncoderUtil passwordEncoder;
	private final JwtUtil jwtUtil;


	public AuthService(UserRepository userRepository, PasswordEncoderUtil passwordEncoder, JwtUtil jwtUtil) 
	{
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}


	public AuthResponse register(RegisterRequest request) 
	{
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		String token = jwtUtil.generateToken(user.getUsername());
		return new AuthResponse(token, "User registered successfully.");
	}


	public AuthResponse login(LoginRequest request) 
	{
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) 
		{
			throw new RuntimeException("Invalid credentials");
		}
		String token = jwtUtil.generateToken(user.getUsername());
		return new AuthResponse(token, "Login Successful");
	}
}