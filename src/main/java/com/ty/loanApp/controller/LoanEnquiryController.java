package com.ty.loanApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.service.LoanEnquiryService;

@Controller
public class LoanEnquiryController {

	@Autowired
	private LoanEnquiryService loanEnquiryService;

	@MutationMapping(name = "createLoanEnquiry")
	public LoanEnquiry createLoanEnquiry(@Argument EnquiryDto inputLoanEnquiry) {
		return loanEnquiryService.saveLoanEnquiry(inputLoanEnquiry);
	}

	@QueryMapping
	public LoanEnquiry getLoanEnquiryByAccountNumber(@Argument String accountnumber) {
		return loanEnquiryService.getLoanEnquiryByAccountNumber(accountnumber);
	}
	
	@MutationMapping
	public String deleteLoanEnquiryByEnquiryId(@Argument int loanEnquiryId) {
		return loanEnquiryService.deleteLoanEnquiryByEnquiryId(loanEnquiryId);
	}
	
	@MutationMapping
	public String deleteLoanEnquiryByBankId(@Argument String bankId) {
		return loanEnquiryService.deleteLoanEnquiryByBankId(bankId);
	}
	
	@MutationMapping
	public String deleteLoanEnquiryByBranchId(@Argument String branchId) {
		return loanEnquiryService.deleteLoanEnquiryByBranchId(branchId);
	}
	
	@QueryMapping
	public List<LoanEnquiry> getAllLoanEnquiryByBranchId(@Argument String branchId)
	{
		return loanEnquiryService.findAllByBranchId(branchId);
	}
	
	@QueryMapping
	public List<LoanEnquiry> getAllLoanEnquiryByBankId(@Argument String bankId)
	{
		return loanEnquiryService.findAllByBankId(bankId);
	}
	
	@QueryMapping
	public boolean checkLoanEnquiryByBankId(@Argument String bankId)
	{
		return loanEnquiryService.checkLoanEnquiryByBankId(bankId);
	}
	
	@QueryMapping
	public boolean checkLoanEnquiryByBranchId(@Argument String branchId)
	{
		return loanEnquiryService.checkLoanEnquiryByBranchId(branchId);
	}
}