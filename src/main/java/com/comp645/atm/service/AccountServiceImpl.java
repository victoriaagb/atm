package com.comp645.atm.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Customer;
import com.comp645.atm.model.Transaction;
import com.comp645.atm.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionService transactionService;

	public Account createAccount(Customer customer, Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public Double checkBalance(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account retrieveAccount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> retrieveAccounts(Customer customer) {
		List<Account> accounts = accountRepository.findByCustomer(customer);
		return accounts;
	}

	public void accountDialog(Account account, Atm atm) {
		transactionService.transactionDialog(account, atm);

	}

	public void accountDialogs(Customer customer, Atm atm) {
		List<Account> accounts = retrieveAccounts(customer);
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Select account for transaction. \n");
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			System.out.printf(i+1 + " ) " + account.getAccountType() + " " + account.getAccountNumber());
		}
		int option = sc.nextInt() - 1;
		sc.nextLine();
		accountDialog(accounts.get(option), atm);

	}

	public Account updateAccount(Account account) {
		return accountRepository.save(account);
		
	}

}
