package com.ty.loanApp.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.repository.LoanEnquiryStepProcessRepository;

public class LoanEnquiryStepProcessDaoImplementation implements LoanEnquiryStepProcessDao {

	@Autowired
	private LoanEnquiryStepProcessRepository loanEnquiryStepProcessRepository;

	@Override
	public LoanEnquiryStepProcess saveEnquiryStepProcess(LoanEnquiryStepProcess loanEnquiryStepProcess) {
		return loanEnquiryStepProcessRepository.save(loanEnquiryStepProcess);
	}

}
