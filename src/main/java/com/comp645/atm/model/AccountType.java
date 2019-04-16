package com.comp645.atm.model;

public enum AccountType {

	DEBIT("DEBIT"), CREDIT("CREDIT");

	private final String text;

	AccountType(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
