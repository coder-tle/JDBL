package com.digiLib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiLib.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
