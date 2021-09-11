package com.newProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newProject.models.User;
import com.newProject.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public String addUsers(String username, String usermobile, String pass, String address, String usertype,
			String useremail) {
		
		User user = new User();
		user.setUserAddress(address);
		user.setUserEmail(useremail);
		user.setUserMobile(usermobile);
		user.setUserName(username);
		user.setUserType(usertype);
		user.setUserPass(pass);
		
		try{userRepository.save(user); 
			return "Data Saved Successfully";
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public String updateUsers(int id, String username, String usermobile, String pass, String address, String usertype,
			String useremail) {
		
		User user = new User();
		user.setId(id);
		user.setUserName(username);
		user.setUserAddress(address);
		user.setUserEmail(useremail);
		user.setUserMobile(usermobile);
		
		user.setUserType(usertype);
		user.setUserPass(pass);
		
		try{userRepository.save(user); 
			return "Data Update Successfully";
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public User fetchId(int id){
		User userRecords = userRepository.getUserById(id);
		return userRecords;
		
	}
	public User fetchEmail(String email){
		User userRecords = userRepository.getUserByEmail(email);
		return userRecords;
		
	}
	
}
