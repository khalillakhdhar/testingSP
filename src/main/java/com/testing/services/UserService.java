package com.testing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testing.model.User;
import com.testing.repo.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
	}
	public User getUserById(Long userId) {
	return userRepository.findById(userId).orElse(null);
	}
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	public List<User> getAlList()
	{
		return userRepository.findAll();
	}
}
