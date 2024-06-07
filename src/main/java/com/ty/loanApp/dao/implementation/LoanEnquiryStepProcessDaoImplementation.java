package com.ty.loanApp.dao.implementation;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.exception.LoanEnquiryProcessIdNotFound;
import com.ty.loanApp.repository.LoanEnquiryStepProcessRepository;

@Repository
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
	public LoanEnquiryStepProcess updateEnquiryStepProcess(int processId,
			LoanEnquiryStepProcess loanEnquiryStepProcess) {
		LoanEnquiryStepProcess repoEnquiryStepProcess = getEnquiryStepProcess(processId);
		if (repoEnquiryStepProcess != null) {
			loanEnquiryStepProcess.setProcessId(processId);
			return loanEnquiryStepProcessRepository.save(loanEnquiryStepProcess);
		}
		throw new LoanEnquiryProcessIdNotFound("Loan Enquiry process ID Not Found");

	}

	@Override
	public String deleteEnquiryStepProcess(int processId) {
		loanEnquiryStepProcessRepository.delete(getEnquiryStepProcess(processId));
		return "DELETED";
	}

	@Override
	public LoanEnquiryStepProcess getEnquiryStepProcess(int processId) {
		Optional<LoanEnquiryStepProcess> op = loanEnquiryStepProcessRepository.findById(processId);
		if (op.isPresent()) {
			return op.get();
		}
		throw new LoanEnquiryProcessIdNotFound("Loan Enquiry process ID Not Found");
	}

	@Override
	public boolean loanEnnquiryStepIsCompleted(String accountNumber, int stepCount) {
		return loanEnquiryStepProcessRepository.loanEnnquiryStepIsCompleted(accountNumber, stepCount);
	}

	@Override
	public long getLoanEquiryIdStepOne(String accountNumber) {
		return loanEnquiryStepProcessRepository.getLoanEquiryIdStepOne(accountNumber);
	}

	@Override
	public long getLoanEquiryIdStepTwo(String accountNumber) {
		return loanEnquiryStepProcessRepository.getLoanEquiryIdStepTwo(accountNumber);
	}

}
