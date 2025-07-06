package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.CreateUserRequest;
import com.example.models.User;
import com.example.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/") // here we are doing wrong like that we are returrning all the fields to user 
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	// create user 
	// only allow some field to be set by the users 
	// @Valid annotation will only accept request payload vaildated via CreateUserREquest
	@PostMapping("/")
	public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequest request){
		return ResponseEntity.ok("dummy create");
	}
//	
}
