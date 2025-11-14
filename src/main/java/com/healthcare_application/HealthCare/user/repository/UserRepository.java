package com.healthcare_application.HealthCare.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.elastic.clients.elasticsearch.security.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
	Optional<User> findByUsername(String username);
}