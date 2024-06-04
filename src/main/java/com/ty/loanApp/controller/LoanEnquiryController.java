package com.ty.loanApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ty.loanApp.dto.LoanEnquiryInput;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.service.LoanEnquiryService;

@Controller
public class LoanEnquiryController {

	@Autowired
	private LoanEnquiryService loanEnquiryService;

	@MutationMapping(name = "createLoanEnquiry")
	public LoanEnquiry createLoanEnquiry(@Argument LoanEnquiryInput inputLoanEnquiry) {
		return loanEnquiryService.saveLoanEnquiry(inputLoanEnquiry);
	}

	@QueryMapping(name = "getLoanEnquiryById")
	public void getLoanEnquiryById(int id) {
		System.out.println("Hi");
	}
}