package org.krd.khmer.service;

import java.util.List;

import org.krd.khmer.model.User;

public interface UserService {
	public List<User> findAll();
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(String user_hash);
	public User findone(String user_hash);
	public User detail(String user_hash);
	int countTotal();
	int countMale();
	int countFemale();
	int countUserfales();
	
}
