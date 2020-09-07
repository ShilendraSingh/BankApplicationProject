package com.bank.demo.service;

@Service
public class TransationServiceImpl implements TransationService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransationRepository transationRepository;

	@Override
	public TransationResponsedto fundtransfer(Transationdto transationdto) {
		
		if(transationdto.getAmount()>0)
		{
			Account sender= accountRepository.findByAccountNumber(transationdto.getFromAccount());   
			Account reciever=accountRepository.findByAccountNumber(transationdto.getToAccount());
			if(!(transationdto.getFromAccount()==transationdto.getToAccount()))
			{
				if(sender.getBalance()>=transationdto.getAmount())
				{
					Transation transationCredit=new Transation();
					Transation transationDebit=new Transation();
					double debit=sender.getBalance()-transationdto.getAmount();
					sender.setBalance(debit);
					accountRepository.save(sender);
					double credit=reciever.getBalance()+transationdto.getAmount();
					reciever.setBalance(credit);
					accountRepository.save(reciever);
					
					transationCredit.setAmount(transationdto.getAmount());
					transationCredit.setFromAccount(transationdto.getFromAccount());
					transationCredit.setToAccount(transationdto.getToAccount());
					transationCredit.setTransactionDate(LocalDate.now());
					transationCredit.setTransactionType("CREDIT");
					
					transationRepository.save(transationCredit);
					transationDebit.setAmount(transationdto.getAmount());
					transationDebit.setFromAccount(transationdto.getFromAccount());
					transationDebit.setToAccount(transationdto.getToAccount());
					transationDebit.setTransactionDate(LocalDate.now());
					transationDebit.setTransactionType("DEBIT");
					
					transationRepository.save(transationDebit);
					
					
				}
				else
				{
					throw new AmountInsuffcientException("Amount is not succificient");
				}
				
				
			}
			else
			{
				
				
			}
			
			
			
		}
		
		
		
		
		
		return null;
		
		
			}

	@Override
	public List<TransationHistorydto> viewHistory(int Account) {

    List<TransationHistorydto> responseList=new ArrayList<>();
    Pageable pageable = PageRequest.of(0, 10);
	List<Transation> history=	transationRepository.findByFromAccount(Account,pageable);
	for (Transation transation : history) {
		TransationHistorydto transationHistorydto=new TransationHistorydto();
			/*
			 * transationHistorydto.setAmount(transation.getAmount());
			 * transationHistorydto.setFromAccount(transation.getFromAccount());
			 * transationHistorydto.setToAccount(transation.getToAccount());
			 * transationHistorydto.setTransactionDate(transation.getTransactionDate());
			 * transationHistorydto.setTransactionType(transation.getTransactionType());
			 * transationHistorydto.setTransationId(transation.getTransationId());
			 */
		BeanUtils.copyProperties(transation, transationHistorydto);
		
		responseList.add(transationHistorydto);
		
		
	}
		
		return responseList;
	}


}
