package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {
	
	// Firstly autowired the UserRepository
	@Autowired
	public UserRepository userRepo;
	
	//UserRepository userRepo;
	
	public User saveUSer(User u)
	{
		return userRepo.save(u);
	}
	
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}

	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(id);
		
	}

}