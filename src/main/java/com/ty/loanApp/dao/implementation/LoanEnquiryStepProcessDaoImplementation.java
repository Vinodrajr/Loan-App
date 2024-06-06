package com.ty.loanApp.dao.implementation;

import java.util.Optional;

import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.exception.LoanEnquiryProcessIdNotFound;
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

	@Override
	public LoanEnquiryStepProcess updateEnquiryStepProcess(int processId, LoanEnquiryStepProcess loanEnquiryStepProcess) {
		Optional<LoanEnquiryStepProcess> op = loanEnquiryStepProcessRepository.findById(processId);
		if(op.isPresent())
		{
			loanEnquiryStepProcess.setProcessId(processId);
			loanEnquiryStepProcessRepository.save(loanEnquiryStepProcess);
		}
		throw new LoanEnquiryProcessIdNotFound("Loan Enquiry process ID Not Found");
	}

	@Override
	public String deleteEnquiryStepProcess(int processId) {
		Optional<LoanEnquiryStepProcess> op = loanEnquiryStepProcessRepository.findById(processId);
		if(op.isPresent())
		{
			loanEnquiryStepProcessRepository.delete(op.get());
		}
		throw new LoanEnquiryProcessIdNotFound("Loan Enquiry process ID Not Found");
	}

	@Override
	public LoanEnquiryStepProcess getEnquiryStepProcess(int processId) {
		Optional<LoanEnquiryStepProcess> op = loanEnquiryStepProcessRepository.findById(processId);
		if(op.isPresent())
		{
			return op.get();
		}
		throw new LoanEnquiryProcessIdNotFound("Loan Enquiry process ID Not Found");
	}

}
