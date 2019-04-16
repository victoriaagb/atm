package com.comp645.atm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp645.atm.model.Account;
import com.comp645.atm.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByAccount(Account account);

}
