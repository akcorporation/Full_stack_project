package com.newProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.newProject.Dto.UserDto;
import com.newProject.models.User;
import com.newProject.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("User/add")
	public String addUser(UserDto userDetail) {

		String response = userservice.addUsers(userDetail);
		return response;
		
	}
	
	@GetMapping("User/id/{id}")
	public UserDto getUserById(@PathVariable Long id){

		UserDto userDetail = userservice.fetchId(id);
		return userDetail;
	}
	
	@GetMapping("User/email/{email}")
	public UserDto getUserByEmail(@PathVariable String email){
		
		UserDto userDetail = userservice.fetchEmail(email);
		return userDetail;
	}
	
	@PutMapping("User/update")
	public String updateUser(User user) {

		String response = userservice.updateUsers(user);
		return response;
		
	}
	@DeleteMapping("User/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		String response = userservice.deleteUser(id);
		return response;
	}

}
