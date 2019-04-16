package com.comp645.atm.service;

import com.comp645.atm.model.Customer;

public interface CustomerService {
	
	public Customer login (Long customerId, String password);
	
	public Customer createCustomer (Customer customer, String password);
	
	public Customer customerDialog();
	
	public Customer dialog ();
	
}
