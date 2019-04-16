package com.comp645.atm.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp645.atm.model.Bank;
import com.comp645.atm.repositories.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired 
	BankRepository bankRepository;
	
	public Bank createBank(Bank bank) {
		Bank newBank = bankRepository.save(bank);
		return newBank;
	}

	public Bank getBank(Bank theBank) {
		Bank bank = bankRepository.findByBankId(theBank.getBankId());
		return bank;
	}
	
	public Bank createBankDialog() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of the Bank");
		String bankName = sc.nextLine();
		sc.close();
		
		Bank theBank = new Bank();
		theBank.setName(bankName);
		
		Bank newBank = createBank(theBank);
		return newBank;
		
	}
	

}
