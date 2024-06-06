package com.ty.loanApp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.service.LoanEnquiryStepProcessService;

@Service
public class LoanEnquiryStepProcessServiceImplementation implements LoanEnquiryStepProcessService{

	@Autowired
	private LoanEnquiryStepProcessDao loanEnquiryStepProcessDao;
	
	@Override
	public boolean loanEnnquiryStepIsCompleted(String accountNumber, int stepCount) {
		return loanEnquiryStepProcessDao.loanEnnquiryStepIsCompleted(accountNumber, stepCount);
	}

}
