package com.instagram.clone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.instagram.clone.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
}
