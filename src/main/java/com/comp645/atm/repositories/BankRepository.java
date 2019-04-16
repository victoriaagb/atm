package com.comp645.atm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp645.atm.model.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

	Bank findByBankId(Long bankId);

}
