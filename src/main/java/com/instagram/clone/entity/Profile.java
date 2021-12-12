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
public class Profile {
	
	public Profile() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_seq")
	private Long profileSeq;
	
	
	@NonNull
	@Column(name="account_seq")
	private Long accountSeq;
	
	@NonNull
	@Column(name="name", length = 25)
	private String name;
	
	@Column(name="web_site", length = 255)
	private String webSite;
	
	@Column(name="introduce", length = 255)
	private String introduce;
	
	
	@Generated(GenerationTime.INSERT) 
	@Column
	private Date createdAt;

	
	@Generated(GenerationTime.ALWAYS)  
	@Column
	private Date updatedAt;
	
	
}
