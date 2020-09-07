package com.bank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.dto.CustomerRequestdto;
import com.bank.demo.dto.CustomerResponsedto;
import com.bank.demo.service.RegistrationService;

@RestController
@RequestMapping("/bank")
public class RegistrationController {
	
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public  ResponseEntity<CustomerResponsedto> register(@RequestBody CustomerRequestdto customerRequestdto )
	{
		return new ResponseEntity<>(registrationService.register(customerRequestdto),HttpStatus.CREATED);
	}

}
