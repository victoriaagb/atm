package com.comp645.atm.service;

import java.util.List;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Customer;
import com.comp645.atm.model.Transaction;

public interface AccountService {
	
	public Double checkBalance(Account account);
	
	public Account retrieveAccount(String accountId);
	
	public List<Account> retrieveAccounts(Customer customer);
	
	public Account createAccount(Customer customer, Account account);
	
	public void accountDialog(Account account, Atm atm);
	
	public void accountDialogs(Customer customer, Atm atm);

	public Account updateAccount(Account account);
}
