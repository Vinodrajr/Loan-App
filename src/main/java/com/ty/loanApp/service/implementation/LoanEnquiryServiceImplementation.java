package com.ty.loanApp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.dto.LoanEnquiryInput;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.service.LoanEnquiryService;

@Service
public class LoanEnquiryServiceImplementation implements LoanEnquiryService {

	@Autowired
	private LoanEnquiryDao loanEnquiryDao;

	@Override
	public LoanEnquiry saveLoanEnquiry(LoanEnquiryInput inputLoanEnquiry) {

		ObjectMapper mapper = new ObjectMapper();
		LoanEnquiry loanEnquiry = mapper.convertValue(inputLoanEnquiry, LoanEnquiry.class);
		String accountNumber =loanEnquiry.getAccountnumber();
		
		
		return loanEnquiryDao.saveLoanEnquiry(loanEnquiry);
	}

}
