package com.comp645.atm.service;

import com.comp645.atm.model.Bank;

public interface BankService {
	
	public Bank createBank(Bank bank);

	public Bank getBank(Bank theBank);
	
	public Bank createBankDialog();

}
