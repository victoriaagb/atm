package com.comp645.atm.service;

import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Bank;

public interface AtmService {
	

	public Atm createAtm(Atm atm);
	
	public Atm createAtmDialog();
	
	public Atm createAtmDialog(Bank bank);

	public Atm getAtm(Atm atm);

	public Atm updateAtm(Atm atm);
}
