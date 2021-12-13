package com.instagram.clone.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.instagram.clone.dto.AccountDto;
import com.instagram.clone.entity.Account;
import com.instagram.clone.repository.AccountRepository;
import com.instagram.clone.service.AccountService;

import com.google.gson.reflect.TypeToken;


@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	
	private final ModelMapper mapper = new ModelMapper();
	 
	
	@Override
	public AccountDto save(AccountDto accountDto) throws Exception {
		
		// DTO to Entity
		Account	account = mapper.map(accountDto, Account.class);
		account = accountRepository.save(account);
		
		// Entity to DTO
		return mapper.map(account, AccountDto.class); 
	}
	
	   
	@Override
	public List<AccountDto> findAll() throws Exception {
		
		// List<Entity> to List<DTO>
		
		System.out.println(accountRepository.findAll());
		return mapper.map(accountRepository.findAll(),  new TypeToken<List<AccountDto>>(){}.getType());
	}


	@Override
	public AccountDto getAccount(Long accountSeq) throws Exception {
		
		Account	account = accountRepository.findById(accountSeq)
        .orElseThrow(() -> new IllegalArgumentException("illegal argument :" + accountSeq));
		
		// Entity to DTO
		return mapper.map(account, AccountDto.class); 
	}


	@Override
	public void deleteByAccountSeq(Long accountSeq) throws Exception {
		
		accountRepository.deleteById(accountSeq);
		
	}


	@Override
	public void updateAccount(Long accountSeq, AccountDto accountDto) throws Exception {
		
		Optional<Account> account = Optional.of(accountRepository.findById(accountSeq).orElseThrow(() -> new Exception("account not found Exception")));
		
		// DTO to Entity
		
		account.ifPresent(selectAccount ->{
			selectAccount.setAccountId(Optional.ofNullable(accountDto.getAccountId())
					.orElse(selectAccount.getAccountId())
    				);
			selectAccount.setPassword(
					Optional.ofNullable(accountDto.getPassword())
					.orElse(accountDto.getPassword())
					);
		
			selectAccount.setRegType(	
					Optional.ofNullable(accountDto.getRegType())
					.orElse(accountDto.getRegType())
					);
    		
    		Account target = accountRepository.save(selectAccount);
    		
    		System.out.println(target);
    	});
    	
	}
	
}
