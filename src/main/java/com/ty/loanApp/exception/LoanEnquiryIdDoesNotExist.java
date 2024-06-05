package com.ty.loanApp.exception;

public class LoanEnquiryIdDoesNotExist extends RuntimeException {
	
	private String message = "Loan Enquiry ID Not Found";

	public LoanEnquiryIdDoesNotExist() {
		super();
	}

	public LoanEnquiryIdDoesNotExist(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
