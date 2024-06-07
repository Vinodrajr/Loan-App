package com.ty.loanApp.dao;

import org.springframework.graphql.data.method.annotation.Argument;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

public interface LoanEnquiryStepProcessDao {

	LoanEnquiryStepProcess saveEnquiryStepProcess(LoanEnquiryStepProcess loanEnquiryStepProcess);

	LoanEnquiryStepProcess updateEnquiryStepProcess(int processId, LoanEnquiryStepProcess loanEnquiryStepProcess);

	String deleteEnquiryStepProcess(int processId);

	LoanEnquiryStepProcess getEnquiryStepProcess(int processId);

	boolean loanEnnquiryStepIsCompleted( String accountNumber , int stepCount);

	long getLoanEquiryIdStepOne(String accountNumber);

	long getLoanEquiryIdStepTwo(String accountNumber);



}
