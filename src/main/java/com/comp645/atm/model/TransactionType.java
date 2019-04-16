package com.comp645.atm.model;

public enum TransactionType {
	
	WITHDRAW("WITHDRAW"), DEPOSIT("DEPOSIT"), TRANSFER("TRANSFER");

	private final String text;

	TransactionType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}
