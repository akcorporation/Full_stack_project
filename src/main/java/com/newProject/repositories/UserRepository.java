package com.newProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newProject.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {
	
	User save(User user);
	
	@Query(value = "SELECT * FROM USER_MASTER o where o.user_id = :id", 
		    nativeQuery = true)
	User getUserById(Integer id);
	
	@Query(value = "SELECT * FROM USER_MASTER o where o.user_email = :email", 
		    nativeQuery = true)
	User getUserByEmail(String email);
}
