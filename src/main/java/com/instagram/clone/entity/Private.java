package com.instagram.clone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Private {
	
	public Private() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="private_seq")
	private Long privateSeq;
	
	@NonNull
	@Column(name="account_seq")
	private Long accountSeq;
	
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="phone_no", length = 15)
	private String phoneNo;
	
	@Column(name="birthday")
	private int birthday;
	
	@Generated(GenerationTime.INSERT) 
	@Column
	private Date createdAt;

	
	@Generated(GenerationTime.ALWAYS)  
	@Column
	private Date updatedAt;
	
	
}
