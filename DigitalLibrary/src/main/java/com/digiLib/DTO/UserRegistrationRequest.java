package com.digiLib.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {
//	@NotBlank(message="name is required");
	private String name;
//	@NotBlank(message="email is required");
	private String email;
//	@NotBlank(message="password is required")
//	@Size(min=8, message="passowrd must be at least 8 char long") // add a custom validation -- like 8 char long, special char, 1 integer--- brownie it shold not match existing one
	private String password;
}
