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
public class profileDto {
	
	@NonNull
	private Long profileSeq;
	
	@NonNull
	private Long accountSeq;
	
	@NonNull
	private String name;
	
	private String webSite;
	
	private String introduce;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	
}
