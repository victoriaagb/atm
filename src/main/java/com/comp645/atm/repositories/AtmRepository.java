package com.comp645.atm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comp645.atm.model.Atm;

@Repository
public interface AtmRepository extends CrudRepository<Atm, Long> {
	Atm findByAtmId(Long Atm);
}
