package com.bank.demo.service;

public interface TransationService {

	public TransationResponsedto  fundtransfer(Transationdto transationdto);
	
	public List<TransationHistorydto> viewHistory (int Account);
	
	

}