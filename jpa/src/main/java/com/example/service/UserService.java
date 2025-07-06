package com.example.service;

import java.util.List;

import com.example.models.User;

public interface UserService {
	public User getUserById(int id);
	public List<User> getAllUser();
	public User addUser(User user);
	public User updateUser(User user, int id);
	public boolean deleteUser(int id);
	public User searchUserByName(String email);
}
