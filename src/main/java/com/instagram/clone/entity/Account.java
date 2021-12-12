package com.instagram.clone.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NonNull;
import com.instagram.clone.common.BaseTime;

@Entity
@Data
@Table
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseTime {
	
	public Account() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_seq")
	private Long accountSeq;
	
	
	@NonNull
	@Column(name="account_id", length = 150)
	private String accountId;
	
	@NonNull
	@Column(name="password", length = 100)
	private String password ;
	

	@Column(name="t1")
	private String t1;
	
	@Column(name="reg_type", columnDefinition = "varchar(1) default 'N'")
	private String regType;
	

	  
}
