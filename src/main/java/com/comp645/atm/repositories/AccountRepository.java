package com.comp645.atm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Customer;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	List<Account> findByCustomer(Customer customer);

}
