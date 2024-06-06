package com.ty.loanApp.dao;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

public interface LoanEnquiryStepProcessDao {

	LoanEnquiryStepProcess saveEnquiryStepProcess(LoanEnquiryStepProcess loanEnquiryStepProcess);
	
	LoanEnquiryStepProcess updateEnquiryStepProcess(int processId, LoanEnquiryStepProcess loanEnquiryStepProcess);
	
	String deleteEnquiryStepProcess(int processId);
	
	LoanEnquiryStepProcess getEnquiryStepProcess(int processId);
	
	
}
