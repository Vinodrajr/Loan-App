package com.ty.loanApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.service.LoanEnquiryService;
import com.ty.loanApp.service.LoanEnquiryStepProcessService;

@Controller
public class LoanEnquiryController {

	@Autowired
	private LoanEnquiryService loanEnquiryService;

	@Autowired
	private LoanEnquiryStepProcessService loanEnquiryStepProcessService;

	@MutationMapping(name = "loanEnquiryStepOne")
	public LoanEnquiry loanEnquiryStepOne(@Argument EnquiryDto inputLoanEnquiry) {
		return loanEnquiryService.loanEnquiryStepOne(inputLoanEnquiry);
	}

	@QueryMapping(name = "getLoanEnquiryStepOne")
	public LoanEnquiry getLoanEnquiryStepOne(@Argument String accountNumber) {
		return loanEnquiryService.getLoanEnquiryStepOne(accountNumber);
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
	public List<LoanEnquiry> getAllLoanEnquiryByBranchId(@Argument String branchId) {
		return loanEnquiryService.findAllByBranchId(branchId);
	}

	@QueryMapping
	public List<LoanEnquiry> getAllLoanEnquiryByBankId(@Argument String bankId) {
		return loanEnquiryService.findAllByBankId(bankId);
	}

	@QueryMapping
	public boolean checkLoanEnquiryByBankId(@Argument String bankId) {
		return loanEnquiryService.checkLoanEnquiryByBankId(bankId);
	}

	@QueryMapping
	public boolean checkLoanEnquiryByBranchId(@Argument String branchId) {
		return loanEnquiryService.checkLoanEnquiryByBranchId(branchId);
	}

	@QueryMapping
	public boolean loanEnnquiryStepIsCompleted(@Argument String accountNumber, @Argument int stepCount) {
		return loanEnquiryStepProcessService.loanEnnquiryStepIsCompleted(accountNumber, stepCount);
	}

}