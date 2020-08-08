package com.scrapbot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scrapbot.entity.User;
import com.scrapbot.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
  
	@Transactional(readOnly = true)
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
  
  
	public List<User> findAll(){  
		return userRepository.findAll();
	}

  
}