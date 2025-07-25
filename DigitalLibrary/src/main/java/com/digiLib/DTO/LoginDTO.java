package com.digiLib.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Builder
//add jakarata.validaion.
public class LoginDTO {
//	@NotBlank(message="email cannot be empty")
	private String email;
//	@NotBlank(message="password cannot be empty")
	private String password;
}
