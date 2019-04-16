package com.comp645.atm.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp645.atm.model.Customer;
import com.comp645.atm.repositories.CustomerRepository;
import com.comp645.atm.utils.PasswordUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer login(Long customerId, String password) {

		Customer customer = null;
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if (customerOpt.isPresent()) {
			Customer potential = customerOpt.get();
			boolean passwordMatch = PasswordUtils.verifyPassword(password, potential.getKey(), potential.getSalt());
			if (passwordMatch) {
				customer = potential;
			}
		}

		return customer;
	}

	public Customer createCustomer(Customer customer, String password) {

		Customer newCustomer;
		try {

			Optional<String> saltOpt = PasswordUtils.generateSalt(2);
			String salt = saltOpt.get();
			Optional<String> keyOpt = PasswordUtils.hashPassword(password, salt);
			String key = keyOpt.get();

			customer.setSalt(salt);
			customer.setKey(key);
			newCustomer = customerRepository.save(customer);
		} catch (Exception ex) {
			return null;
		}

		return newCustomer;
	}

	public Customer dialog() {
		Scanner sc = new Scanner(System.in);
		Customer customer = null;
		int option = 0;

		System.out.printf("Please select the following options \n");
		System.out.println("  1) Login");
		System.out.println("  2) New Customer");
		
		option = sc.nextInt();
		sc.nextLine();
		
		if (option == 1) {
			System.out.printf("Please input your card number \n");
			Long customerId = sc.nextLong();
			sc.nextLine();
			System.out.printf("Please input your pin \n");
			String pin = sc.nextLine();
			customer = login(customerId, pin);
			
		} else if (option == 2) {
			System.out.println("Enter First Name");
			String firstName = sc.nextLine();
			System.out.println("Enter Last Name");
			String lastName = sc.nextLine();
			System.out.println("Enter Social Security Number");
			String ssn = sc.nextLine();
			System.out.println("Enter user Pin Number");
			String pin = sc.nextLine();

			Customer newCustomer = new Customer();
			newCustomer.setFirstName(firstName);
			newCustomer.setLastName(lastName);
			newCustomer.setSocial(ssn);
			
			customer = createCustomer(newCustomer, pin);
			
			System.out.println("Your card number is: " + customer.getCustomerId());

		}
		return customer;
		
	}

	public Customer customerDialog() {
		Customer customer = null;
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		while (!valid) {

			System.out.printf("Welcome. To start, please provide the following information. \n");
			System.out.printf("Card Number: \n");
			Long customerId = sc.nextLong();
			sc.nextLine();
			
			System.out.printf("Pin Number: \n");
			String pin = sc.nextLine();
			try {
				customer = login(customerId, pin);
			} catch (Exception ex) {
				customer = null;
				System.out.printf("Invalid input. \n");
			}
			if (customer != null) {
				valid = true;
			}
			
		}
		return customer;
	}

}
