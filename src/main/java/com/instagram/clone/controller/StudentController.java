package com.instagram.clone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.clone.dto.AccountDto;
import com.instagram.clone.service.AccountService;
import com.google.gson.JsonObject;


@RestController
@RequestMapping("/v1")
public class StudentController {
    
	@Autowired
	private AccountService accountService;
	
	//생성 
	@PostMapping("/account")
    public ResponseEntity<?> saveStudent(@RequestBody AccountDto studentDto) throws Exception {
		AccountDto savedStudent = accountService.save(studentDto);
        return ResponseEntity.ok(savedStudent);
    }
	
	// 목록 조회
    @GetMapping("/account")
    public List<AccountDto> all() throws Exception {
        return accountService.findAll();
    }
    
    
    // 단건 조회
    @GetMapping("/account/{accountSeq}")
    public AccountDto getAccount(@PathVariable Long accountSeq) throws Exception {
        return Optional.of(accountService.getAccount(accountSeq)).orElseThrow(() -> new Exception("Account not found Exception"));
    }
    
    
  	// 수정 
    @PutMapping("/account/{accountSeq}")
    public ResponseEntity<?> updateAccount(@PathVariable Long accountSeq, @RequestBody AccountDto accountDto) throws Exception {
    	
    	Optional.of(accountService.getAccount(accountSeq)).orElseThrow(() -> new Exception("Account not found Exception"));
    	
    	accountService.updateAccount(accountSeq, accountDto);
		
		 JsonObject resp = new JsonObject();
		    resp.addProperty("status", 0);
		    resp.addProperty("accountSeq", accountSeq);

		    return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
    }

    
  	// 삭제
    @DeleteMapping("/account/{accountSeq}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountSeq) throws Exception {
    	
    	Optional.of(accountService.getAccount(accountSeq)).orElseThrow(() -> new Exception("Account not found Exception"));
    	
    	accountService.deleteByAccountSeq(accountSeq);
		
		 JsonObject resp = new JsonObject();
		    resp.addProperty("status", 0);
		    resp.addProperty("accountSeq", accountSeq);

		    return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
    }
}
