package com.comp645.atm;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Atm;
import com.comp645.atm.model.Customer;
import com.comp645.atm.service.AccountService;
import com.comp645.atm.service.AtmService;
import com.comp645.atm.service.CustomerService;

@Component
public class AppStartupRunner implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(AppStartupRunner.class);

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private AtmService atmService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("ATM PROGRAM START", args.getOptionNames());
		Atm atm = new Atm();
		atm.setAtmId((long) 1);
		atm = atmService.getAtm(atm);
		
		while (true) {
			Customer customer = customerService.dialog();
			if (customer != null) {
				accountService.accountDialogs(customer, atm);
				
			} else {
				System.out.printf("Invalid Input \n");
			}
		}
		
		
	}
}
