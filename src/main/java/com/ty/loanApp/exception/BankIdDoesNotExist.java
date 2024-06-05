package com.ty.loanApp.exception;

public class BankIdDoesNotExist extends RuntimeException {
	private String message = "Bank ID Found";

	public BankIdDoesNotExist() {
		super();
	}

	public BankIdDoesNotExist(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
