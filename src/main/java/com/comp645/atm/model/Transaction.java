package com.comp645.atm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class Transaction {
	
	@Id
	@GeneratedValue
	public Long transactionId;
	
	@ManyToOne
	@JoinColumn(name = "accountId", nullable = false)
	public Account account;
	
	public Double amount;
	
	public String date;
	
	@ManyToOne
	@JoinColumn(name = "atmId", nullable = false)
	public Atm atm;
	
	public String transactionType;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString() {
		String trans = "Transaction{ id: " + transactionId + ", transactionType: " + transactionType +", account: " + account.getAccountId() + ", atm: " + atm.getAtmId() + ", amount: " + amount + ", date: " + date + " }";
		return trans;
	}

}
