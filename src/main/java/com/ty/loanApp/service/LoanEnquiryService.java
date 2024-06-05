package com.ty.loanApp.service;

import java.util.List;

import com.ty.loanApp.dto.LoanEnquiryInput;
import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryService {
	
	
	public LoanEnquiry saveLoanEnquiry(LoanEnquiryInput inputLoanEnquiry) ;
	
	public LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber);
	
	public String deleteLoanEnquiryByEnquiryId(long loanEnquiryId);
	
	public String deleteLoanEnquiryByBankId(String bankId);
	
	public String deleteLoanEnquiryByBranchId(String branchId);
	
	public List<LoanEnquiry> findAllByBranchId(String branchId);
	
	public List<LoanEnquiry> findAllByBankId(String bankId);
	
	public boolean checkLoanEnquiryByBankId(String bankId);
	
	public boolean checkLoanEnquiryByBranchId(String branchId);

}
