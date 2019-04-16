package com.comp645.atm.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Bank;
import com.comp645.atm.repositories.AtmRepository;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	AtmRepository atmRepository;
	
	@Autowired
	BankService bankService;
	
	public Atm createAtm(Atm atm) {
		Atm newAtm = atmRepository.save(atm);
		return newAtm;
	}
	
	public Atm createAtmDialog() {
	
		Bank bank = bankService.createBankDialog();
		return createAtmDialog(bank);
		
	}
	
	public Atm createAtmDialog(Bank bank) {
		
		Atm atm = new Atm();
		atm.setAmount(10000.00);
		atm.setBank(bank);
		atm.setLocation("cbus");
		
		Atm newAtm = createAtm(atm);
		return newAtm;
		
	}

	public Atm getAtm(Atm atm) {
		Atm theAtm = atmRepository.findByAtmId(atm.getAtmId());
		return theAtm;
	}

	public Atm updateAtm(Atm atm) {
		Atm updateAtm = atmRepository.save(atm);
		return updateAtm;
		
	}
	


}
