package com.ty.loanApp.dao.implementation;

import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.repository.LoanEnquiryStepProcessRepository;

public class LoanEnquiryStepProcessDaoImplementation implements LoanEnquiryStepProcessDao {

	private LoanEnquiryStepProcessRepository loanEnquiryStepProcessRepository;

	public LoanEnquiryStepProcessDaoImplementation(LoanEnquiryStepProcessRepository loanEnquiryStepProcessRepository) {
		this.loanEnquiryStepProcessRepository = loanEnquiryStepProcessRepository;
	}

	@Override
	public LoanEnquiryStepProcess saveEnquiryStepProcess(LoanEnquiryStepProcess loanEnquiryStepProcess) {
		return loanEnquiryStepProcessRepository.save(loanEnquiryStepProcess);
	}

}
