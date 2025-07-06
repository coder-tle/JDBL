package com.example.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
	
	// validation on input field 
	@NotBlank(message="name is required")
	@Size(max=100, message="name should not be more than 100")
	private String name;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CreateUserRequest [name=" + name + ", email=" + email + "]";
	}
	
}
