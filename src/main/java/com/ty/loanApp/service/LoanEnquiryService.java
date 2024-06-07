package com.ty.loanApp.service;

import java.util.List;

import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryService {

	

	LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber);

	String deleteLoanEnquiryByEnquiryId(long loanEnquiryId);

	String deleteLoanEnquiryByBankId(String bankId);

	String deleteLoanEnquiryByBranchId(String branchId);

	List<LoanEnquiry> findAllByBranchId(String branchId);

	List<LoanEnquiry> findAllByBankId(String bankId);

	boolean checkLoanEnquiryByBankId(String bankId);

	boolean checkLoanEnquiryByBranchId(String branchId);

	LoanEnquiry getLoanEnquiryStepOne(String accountNumber);

	LoanEnquiry getLoanEnquiryStepTwo(String accountNumber);

}
