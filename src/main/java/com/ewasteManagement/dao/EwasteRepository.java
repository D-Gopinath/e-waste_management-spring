package com.ewasteManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ewasteManagement.model.EwasteData;

@Repository
public interface EwasteRepository extends JpaRepository<EwasteData,Integer>{
	
	EwasteData save(EwasteData data);
	
	@Query("select e from com.ewasteManagement.model.EwasteData e where e.uid=:userId")
	List<EwasteData> viewByUserId(@Param("userId") Integer userId);
	
	@Query("select e from com.ewasteManagement.model.EwasteData e where e.fid=:facilityId")
	List<EwasteData> viewByFacilityId(@Param("facilityId") Integer facilityId);
	
}
