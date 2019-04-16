package com.comp645.atm.service;

import java.util.List;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Transaction;

public interface TransactionService {
	
	public Transaction depositToAccount(Account account, Double amount, Atm atm);
	
	public Transaction withdrawFromAccount(Account account, Double amount, Atm atm);
	
	public Transaction transferToAccount(Account sourceAccount, Account targetAcount, Double amount, Atm atm);
	
	public Transaction checkBalance(Account account);

	public void transactionDialog(Account account, Atm atm);

	
}
