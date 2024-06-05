package com.ty.loanApp.service.exception;

public class AccountNumberNotFound extends RuntimeException {

	private String message = "Acount Number Not Found";

	public AccountNumberNotFound() {
		super();
	}

	public AccountNumberNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
