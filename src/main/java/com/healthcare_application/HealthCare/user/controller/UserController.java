package com.healthcare_application.HealthCare.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare_application.HealthCare.user.entity.User;
import com.healthcare_application.HealthCare.user.repository.UserRepository;





@RestController
@RequestMapping("/users")
public class UserController 
{


	private final UserRepository userRepository;


	public UserController(UserRepository userRepository) 
	{
		this.userRepository = userRepository;
	}


	@GetMapping
	public List<User> getAllUsers() 
	{
		return userRepository.findAll();
	}


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) 
	{
		return userRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}


	@PostMapping
	public User createUser(@RequestBody User user) 
	{
		return userRepository.save(user);
	}


	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) 
	{
			return userRepository.findById(id).map(user -> 
			{
				user.setUsername(updatedUser.getUsername());
				user.setPassword(updatedUser.getPassword());
				user.setFullName(updatedUser.getFullName());
				user.setEmail(updatedUser.getEmail());
				user.setPhone(updatedUser.getPhone());
				return ResponseEntity.ok(userRepository.save(user));
			}).orElse(ResponseEntity.notFound().build());
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) 
	{
		if (userRepository.existsById(id)) 
		{
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} 
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
}
