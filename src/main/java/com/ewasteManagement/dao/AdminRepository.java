package com.ewasteManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ewasteManagement.model.Facility;
import com.ewasteManagement.model.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from com.ewasteManagement.model.User u where u.email=:userEmail and role= 'admin' ")
	User findByEmail(@Param("userEmail") String userEmail);
	
	//To view all the user
	List<User> findAll();
	
	@Modifying
	@Query("delete from com.ewasteManagement.model.User u where u.id=:id")
	void deleteById(@Param("id") Integer id);
	
	@Query("select f from com.ewasteManagement.model.Facility f")
	List<Facility> findAllFacility();
	
	@Modifying
	@Query("delete from com.ewasteManagement.model.Facility f where f.id=:id")
	void deleteFacilityById(@Param("id") Integer id);

}
