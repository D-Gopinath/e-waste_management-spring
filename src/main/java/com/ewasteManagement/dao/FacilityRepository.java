package com.ewasteManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ewasteManagement.model.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Integer>{
	
	@SuppressWarnings("unchecked")
	Facility save(Facility facility);
	
	@Query("select f from com.ewasteManagement.model.Facility f where f.email=:companyEmail")
	Facility findByEmail(@Param("companyEmail") String companyEmail);
	
	List<Facility> findAll();
	
	@Transactional
	@Modifying
	@Query("update com.ewasteManagement.model.EwasteData e set e.status = :status where e.uid=:uId and e.fid=:fId")
	void updateStatus(@Param("uId") Integer uId,@Param("fId") Integer fId, @Param("status") String status);
}
