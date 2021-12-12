package com.instagram.clone.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PrivateDto {
	
	@NonNull
	private Long privateSeq;
	
	@NonNull
	private Long accountSeq;
	
	private String email;
	
	private String phoneNo;
	
	private String birthday;
	
	private Date createdAt;

	private Date updatedAt;
	
}
