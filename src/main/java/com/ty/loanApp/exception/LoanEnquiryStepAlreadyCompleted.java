package com.ty.loanApp.exception;

public class LoanEnquiryStepAlreadyCompleted extends RuntimeException {

	private String message = "This step is already completed for the given account number";

	public LoanEnquiryStepAlreadyCompleted() {
		super();
	}

	public LoanEnquiryStepAlreadyCompleted(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
