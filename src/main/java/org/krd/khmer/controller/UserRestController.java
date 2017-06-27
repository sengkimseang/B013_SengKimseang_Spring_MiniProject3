package org.krd.khmer.controller;

import java.util.List;

import org.krd.khmer.model.User;
import org.krd.khmer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	private UserService userService;
	@Autowired
	public UserRestController(UserService userService){
		this.userService = userService;
		
	}
	
	
	public List<User> findAll(){
		return userService.findAll();
		
	}
}
