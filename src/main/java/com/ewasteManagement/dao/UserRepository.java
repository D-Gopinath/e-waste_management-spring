package com.ewasteManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ewasteManagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	//For Registration
	@SuppressWarnings("unchecked")
	User save(User user);
	
	//For Login
	@Query("select u from com.ewasteManagement.model.User u where u.email=:userEmail")
	User findByEmail(@Param("userEmail") String userEmail);
	
	

}
