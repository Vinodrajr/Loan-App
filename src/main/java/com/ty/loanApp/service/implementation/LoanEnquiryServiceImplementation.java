package com.ty.loanApp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.dto.LoanEnquiryInput;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.proxy.AccountControllerProxy;
import com.ty.loanApp.service.LoanEnquiryService;
import com.ty.loanApp.service.exception.AccountNumberNotFound;

@Service
public class LoanEnquiryServiceImplementation implements LoanEnquiryService {

	@Autowired
	private LoanEnquiryDao loanEnquiryDao;

	@Autowired
	private AccountControllerProxy proxy;

	@Override
	public LoanEnquiry saveLoanEnquiry(LoanEnquiryInput inputLoanEnquiry) {

		ObjectMapper mapper = new ObjectMapper();
		LoanEnquiry loanEnquiry = mapper.convertValue(inputLoanEnquiry, LoanEnquiry.class);
		if (proxy.checkAccountNumberExist(loanEnquiry.getAccountnumber()).getBody().getData())
			return loanEnquiryDao.saveLoanEnquiry(loanEnquiry);
		throw new AccountNumberNotFound("Invalid Account Number");
	}

}
