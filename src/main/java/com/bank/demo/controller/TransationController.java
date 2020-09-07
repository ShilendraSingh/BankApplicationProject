package com.bank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/bank")
public class TransationController {

	@Autowired
	private TransationService transationService;
	
	@PostMapping("/fundtransfer")
	public  ResponseEntity<TransationResponsedto> fundtransfer(@RequestBody Transationdto transationdto )
	{
		return new ResponseEntity<>(transationService.fundtransfer(transationdto),HttpStatus.CREATED);
	}
	
	@GetMapping("/transationhistory/{account}")
	public  ResponseEntity<List<TransationHistorydto>> viewHistory(@PathVariable int account )
	{
		
		return new ResponseEntity<>(transationService.viewHistory(account),HttpStatus.OK);
	}
	
	
}