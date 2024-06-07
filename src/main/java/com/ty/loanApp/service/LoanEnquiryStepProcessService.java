package com.ty.loanApp.service;

import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.dto.OccupationDto;
import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryStepProcessService {
	
	public boolean loanEnnquiryStepIsCompleted( String accountNumber , int stepCount);
	
	LoanEnquiry loanEnquiryStepOne(EnquiryDto inputLoanEnquiry);

	public LoanEnquiry saveStepTwo(OccupationDto occupationDto);
	
	

}
