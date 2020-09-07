package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entity.Transation;

@Repository
public interface TransationRepository extends JpaRepository<Transation, Integer>  {
	
	public List<Transation> findByFromAccount(int Account,Pageable pageable);

	
	
	
}