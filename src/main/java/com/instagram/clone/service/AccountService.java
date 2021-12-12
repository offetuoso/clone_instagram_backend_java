package com.instagram.clone.service;

import java.util.List;

import com.instagram.clone.dto.AccountDto;
import com.instagram.clone.entity.Account;

public interface AccountService {
	
	AccountDto save(AccountDto accountDto) throws Exception;

	List<AccountDto> findAll() throws Exception;

	AccountDto getAccount(Long id) throws Exception;

	void deleteByAccountSeq(Long accountSeq) throws Exception;

	void updateAccount(Long accountSeq, AccountDto accountDto) throws Exception;

}
