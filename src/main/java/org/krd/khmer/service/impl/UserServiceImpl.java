package org.krd.khmer.service.impl;

import java.util.List;
import java.util.UUID;

import org.krd.khmer.model.User;
import org.krd.khmer.repositories.UserRepository;
import org.krd.khmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	public boolean save(User user){
		String users = UUID.randomUUID().toString();
		user.setUser_hash(users);
		return userRepository.save(user);
	}
	@Override
	public boolean update(User user) {
		return userRepository.update(user);
	}
	@Override
	public boolean delete(String user_hash) {
		return userRepository.delete(user_hash);
		

	}
	@Override
	public User findone(String user_hash) {
		return userRepository.findOne(user_hash);
		
		
	}
	@Override
	public User detail(String user_hash) {
		
		return userRepository.detail(user_hash);
	}
	
}
