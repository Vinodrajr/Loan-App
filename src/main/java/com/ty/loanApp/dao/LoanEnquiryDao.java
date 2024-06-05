package com.ty.loanApp.dao;

import java.util.List;

import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryDao {

	public LoanEnquiry saveLoanEnquiry(LoanEnquiry loanEnquiry);
	
	public LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber);
	
	public String deleteLoanEnquiryByEnquiryId(long loanEnquiryId);
	
	public String deleteLoanEnquiryByBankId(String bankId);
	
	public String deleteLoanEnquiryByBranchId(String branchId);
	
	public List<LoanEnquiry> getLoanEnquiryByBankId(String bankId);
	
	public List<LoanEnquiry> getLoanEnquiryByBranchId(String branchId);
	
	public boolean checkLoanEnquiryByBankId(String bankId);
	
	public boolean checkLoanEnquiryByBranchId(String branchId);

}
