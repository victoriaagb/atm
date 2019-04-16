package com.comp645.atm.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Transaction;
import com.comp645.atm.model.TransactionType;
import com.comp645.atm.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AtmService atmService;
	
	@Autowired
	TransactionRepository transactionRepository;

	public Transaction depositToAccount(Account account, Double amount, Atm atm) {
		Transaction transaction = null;
		Double total = account.getBalance() + amount;
		Double atmTotal = atm.getAmount() + amount;
		if (amount > 0) {
			transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setAtm(atm);
			transaction.setAmount(amount);
			transaction.setDate(new Timestamp(System.currentTimeMillis()).toString());
			transaction.setTransactionType(TransactionType.DEPOSIT.toString());
			
			account.setBalance(total);
			atm.setAmount(atmTotal);
			
			Transaction newTransaction = transactionRepository.save(transaction);
			transaction = newTransaction;
			
			accountService.updateAccount(account);
			atmService.updateAtm(atm);
			
		} else {
			System.out.println("Doesn't meet minimum deposit requirement.");
		}
		return transaction;
	}

	public Transaction withdrawFromAccount(Account account, Double amount, Atm atm) {
		Transaction transaction = null;
		Double accountTotal = account.getBalance() - amount;
		Double atmTotal = atm.getAmount() - amount;
		if (accountTotal < 0) {
			System.out.println("Insufficient funds in account.");
		} else if (atmTotal <0) {
			System.out.println("Insufficient funds in atm.");
		} else {
			transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setAtm(atm);
			transaction.setAmount(amount);
			transaction.setDate(new Timestamp(System.currentTimeMillis()).toString());
			transaction.setTransactionType(TransactionType.WITHDRAW.toString());
			
			account.setBalance(accountTotal);
			atm.setAmount(atmTotal);
			
			Transaction newTransaction = transactionRepository.save(transaction);
			transaction = newTransaction;
			
			atmService.updateAtm(atm);
			accountService.updateAccount(account);
		}
		return transaction;
	}

	public Transaction transferToAccount(Account sourceAccount, Account targetAcount, Double amount, Atm atm) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction showTransactionHistory(Account account) {
		Transaction transaction = new Transaction();
		List<Transaction> transactions = transactionRepository.findByAccount(account);
		for (Transaction trans: transactions) {
			System.out.println(trans.toString());
		}
		return transaction;
	}

	public void transactionDialog(Account account, Atm atm) {
		Scanner sc = new Scanner(System.in);
		Transaction transaction = null;
		int option = 1;

		while (option < 5 && option > 0) {
			
			System.out.println("Select one of the following options.");
			System.out.println("  1) Show transaction history");
			System.out.println("  2) Withdraw");
			System.out.println("  3) Deposit");
			System.out.println("  4) Check Balance");
			System.out.println("  5) Quit");

			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				transaction = showTransactionHistory(account);
				break;
			case 2:
				System.out.println("Amount to withdraw: ");
				Double withdraw = sc.nextDouble();
				sc.nextLine();
				transaction = withdrawFromAccount(account, withdraw, atm);
				break;
			case 3:
				System.out.println("Amount to deposit: ");
				Double deposit = sc.nextDouble();
				sc.nextLine();
				transaction = depositToAccount(account, deposit, atm);
				break;
			case 4:
				transaction = checkBalance(account);
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
		
		if (transaction != null) {
			transaction.toString();
		}
		
	}

	public Transaction checkBalance(Account account) {
		Transaction transaction = new Transaction();
		System.out.println("Your balance for account# " + account.getAccountNumber() + " is $" + account.getBalance());
		return transaction;
		
	}

}
