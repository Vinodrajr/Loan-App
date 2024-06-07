package com.ty.loanApp.service;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

public interface LoanEnquiryStepProcessService {
	
	public boolean loanEnnquiryStepIsCompleted( String accountNumber , int stepCount);
	
	

}
