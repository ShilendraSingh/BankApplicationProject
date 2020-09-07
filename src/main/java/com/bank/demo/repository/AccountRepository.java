package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


	Account findByAccountNumber(int accountNumber);
	
	
}