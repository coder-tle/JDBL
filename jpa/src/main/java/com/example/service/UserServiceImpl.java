package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired 
	UserRepository repo;

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User searchUserByName(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
