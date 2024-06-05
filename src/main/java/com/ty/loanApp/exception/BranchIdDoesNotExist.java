package com.ty.loanApp.exception;

public class BranchIdDoesNotExist extends RuntimeException {

	
	private String message = "Branch ID Found";

	public BranchIdDoesNotExist() {
		super();
	}

	public BranchIdDoesNotExist(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
