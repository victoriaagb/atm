package com.comp645.atm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp645.atm.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer findByCustomerId(String customerId);

}
