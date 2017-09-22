package com.example.tutorial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorial.data.UserRepository;
import com.example.tutorial.entity.User;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public boolean canLogin(Long id, String userName, String password) {
		Optional<User> user = Optional.ofNullable(userRepository.findByIdAndUserName(id, userName));

		return user.isPresent() && user.get().getPassword().equals(password);
	}

}
