package com.instagram.clone.dto;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.instagram.clone.common.BaseTime;

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
public class AccountDto extends BaseTime{

	@NonNull
	@Column(name="account_seq")
	private Long accountSeq;
	
	@NonNull
	@Column(name="account_id")
	private String accountId;
	
	@NonNull
	private String password;

	private String t1;
	
	@Column(name="reg_type")
	private String regType;
	
	
	
}
