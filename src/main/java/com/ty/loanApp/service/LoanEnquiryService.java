package com.ty.loanApp.service;

import com.ty.loanApp.dto.LoanEnquiryInput;
import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryService {
	
	
	public LoanEnquiry saveLoanEnquiry(LoanEnquiryInput inputLoanEnquiry) ;
	
	public LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber);

}
