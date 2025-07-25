package com.digiLib.service;

public interface UserService {
	void register(UserRegisterRequest userRegisterRequest);
	void login(String email, String password);
}
