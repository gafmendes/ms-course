package com.example.hr_user.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr_user.entities.User;
import com.example.hr_user.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email) {
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
	
}
