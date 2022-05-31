package com.ewasteManagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ewaste_data")
@NoArgsConstructor
@AllArgsConstructor
public class EwasteData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer uid;
	private String username;
	private Integer fid;
	@Column(name="waste_type")
	private String wasteType;
	private String weight;
	private String proof;
	@Column(name="from_address")
	private String fromAddress;
	@Column(name="date_of_request")
	private LocalDate date;
	private String upi;
	private String status;
}
