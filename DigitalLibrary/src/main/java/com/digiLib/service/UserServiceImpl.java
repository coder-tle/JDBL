package com.digiLib.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiLib.DTO.UserRegistrationRequest;
import com.digiLib.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository userRepo;
	
	@Override
	public void register(UserRegistrationRequest request) {
		// check if user already exists ? 
		if(userRepo.findByEmail(request.getEmail().isPresent)) {
			throw new RunTimeException("email is already registered");
		}
		User user = new User().builder().name(request.getName()).email(request.getEmail).password(request.getPassword).role("USER").build();
		userRepo.save(user);
	}

	@Override
	public void login(String email, String password) {
		// TODO Auto-generated method stub
		
		userRepo.findByEmail(email).filter(user->user.getPassword().equals(password)).orElseThrow(()->new RuntimeException("Invalid Credentials"));

	}

}
