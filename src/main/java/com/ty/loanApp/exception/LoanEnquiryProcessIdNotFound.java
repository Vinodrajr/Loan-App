package com.ty.loanApp.exception;

public class LoanEnquiryProcessIdNotFound extends RuntimeException {

	private String message = "Loan Enquiry Process ID Not Found";

	public LoanEnquiryProcessIdNotFound() {
		super();
	}

	public LoanEnquiryProcessIdNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
