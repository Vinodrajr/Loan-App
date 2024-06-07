package com.ty.loanApp.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.enums.LoanStatus;
import com.ty.loanApp.exception.AccountNumberNotFound;
import com.ty.loanApp.exception.LoanEnquiryIdDoesNotExist;
import com.ty.loanApp.exception.LoanEnquiryStepAlreadyCompleted;
import com.ty.loanApp.proxy.AccountControllerProxy;
import com.ty.loanApp.service.LoanEnquiryService;

@Service
public class LoanEnquiryServiceImplementation implements LoanEnquiryService {

	@Autowired
	private LoanEnquiryDao loanEnquiryDao;

	@Autowired
	private AccountControllerProxy proxy;

	@Autowired
	private LoanEnquiryStepProcess loanEnquiryStepProcess;

	@Autowired
	private LoanEnquiryStepProcessDao loanEnquiryStepProcessDao;

	

	@Override
	public LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber) {
		return loanEnquiryDao.getLoanEnquiryByAccountNumber(accountnumber);
	}

	@Override
	public String deleteLoanEnquiryByEnquiryId(long loanEnquiryId) {
		return loanEnquiryDao.deleteLoanEnquiryByEnquiryId(loanEnquiryId);
	}

	@Override
	public String deleteLoanEnquiryByBankId(String bankId) {
		return loanEnquiryDao.deleteLoanEnquiryByBankId(bankId);
	}

	@Override
	public String deleteLoanEnquiryByBranchId(String branchId) {
		return loanEnquiryDao.deleteLoanEnquiryByBranchId(branchId);
	}

	@Override
	public List<LoanEnquiry> findAllByBranchId(String branchId) {
		return loanEnquiryDao.getLoanEnquiryByBranchId(branchId);
	}

	@Override
	public List<LoanEnquiry> findAllByBankId(String bankId) {
		return loanEnquiryDao.getLoanEnquiryByBankId(bankId);
	}

	@Override
	public boolean checkLoanEnquiryByBankId(String bankId) {
		return loanEnquiryDao.checkLoanEnquiryByBankId(bankId);
	}

	@Override
	public boolean checkLoanEnquiryByBranchId(String branchId) {
		return loanEnquiryDao.checkLoanEnquiryByBranchId(branchId);
	}

	@Override
	public LoanEnquiry getLoanEnquiryStepOne(String accountNumber) {
		long loanEquiryId = loanEnquiryStepProcessDao.getLoanEquiryIdStepOne(accountNumber);
		if (loanEquiryId != 0)
			return loanEnquiryDao.getLoanEnquiryByAccountNumber(accountNumber);
		throw new AccountNumberNotFound("step 1 for accountNumber not found ");

	}

	@Override
	public LoanEnquiry getLoanEnquiryStepTwo(String accountNumber) {
		long enquiryId=loanEnquiryStepProcessDao.getLoanEquiryIdStepTwo(accountNumber);
		if(enquiryId!=0)
			return loanEnquiryDao.getLoanEnquiry(enquiryId);
		throw new LoanEnquiryIdDoesNotExist("Enquiry ID does not exist");
		
	}

}
