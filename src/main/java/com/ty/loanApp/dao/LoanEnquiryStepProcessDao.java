package com.ty.loanApp.dao;

import org.springframework.graphql.data.method.annotation.Argument;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

public interface LoanEnquiryStepProcessDao {

	public LoanEnquiryStepProcess saveEnquiryStepProcess(LoanEnquiryStepProcess loanEnquiryStepProcess);
	
	public LoanEnquiryStepProcess updateEnquiryStepProcess(int processId, LoanEnquiryStepProcess loanEnquiryStepProcess);
	
	public String deleteEnquiryStepProcess(int processId);
	
	public LoanEnquiryStepProcess getEnquiryStepProcess(int processId);
	
	public boolean loanEnnquiryStepIsCompleted( String accountNumber , int stepCount);

	
	
}
