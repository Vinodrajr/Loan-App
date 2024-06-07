package com.ty.loanApp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.dao.LoanEnquiryStepProcessDao;
import com.ty.loanApp.dto.EnquiryDto;
import com.ty.loanApp.dto.OccupationDto;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.entity.LoanEnquiryStepProcess;
import com.ty.loanApp.enums.LoanStatus;
import com.ty.loanApp.exception.AccountNumberNotFound;
import com.ty.loanApp.exception.LoanEnquiryIdDoesNotExist;
import com.ty.loanApp.exception.LoanEnquiryStepAlreadyCompleted;
import com.ty.loanApp.proxy.AccountControllerProxy;
import com.ty.loanApp.service.LoanEnquiryStepProcessService;

@Service
public class LoanEnquiryStepProcessServiceImplementation implements LoanEnquiryStepProcessService {

	@Autowired
	private LoanEnquiryStepProcessDao loanEnquiryStepProcessDao;

	@Autowired
	private LoanEnquiryDao loanEnquiryDao;

	private LoanEnquiryStepProcess loanEnquiryStepProcess;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private AccountControllerProxy proxy;

	@Override
	public boolean loanEnnquiryStepIsCompleted(String accountNumber, int stepCount) {
		return loanEnquiryStepProcessDao.loanEnnquiryStepIsCompleted(accountNumber, stepCount);
	}

	@Override
	public LoanEnquiry loanEnquiryStepOne(EnquiryDto inputLoanEnquiry) {
		ObjectMapper mapper = new ObjectMapper();
		LoanEnquiry loanEnquiry = mapper.convertValue(inputLoanEnquiry, LoanEnquiry.class);
		loanEnquiry.setLoanStatus(LoanStatus.IN_PROGRESS);
		if (proxy.checkAccountNumberExist(loanEnquiry.getAccountnumber()).getBody().getData()) {
			loanEnquiryStepProcess= applicationContext.getBean(LoanEnquiryStepProcess.class);
			loanEnquiryStepProcess.setAccountNumber(loanEnquiry.getAccountnumber());
			loanEnquiryStepProcess.setCompleted(true);
			loanEnquiryStepProcess.setStepCount(1);
			if ((!loanEnquiryStepProcessDao.loanEnnquiryStepIsCompleted(loanEnquiryStepProcess.getAccountNumber(),
					1))) {
				loanEnquiry = loanEnquiryDao.saveLoanEnquiry(loanEnquiry);
				loanEnquiryStepProcess.setLoanEnquiryid(loanEnquiry.getLoanEnquiryId());
				loanEnquiryStepProcessDao.saveEnquiryStepProcess(loanEnquiryStepProcess);
				return loanEnquiry;
			}
			throw new LoanEnquiryStepAlreadyCompleted("Step 1 is Completed for the given Account Number");
		}

		throw new AccountNumberNotFound("Invalid Account Number");
	}

	@Override
	public LoanEnquiry saveStepTwo(OccupationDto occupationDto) {
		String accountNumber = occupationDto.getAccountnumber();
		boolean res = loanEnquiryStepProcessDao.loanEnnquiryStepIsCompleted(accountNumber, 1);
		if (res) {
			long enquiryId = loanEnquiryStepProcessDao.getLoanEquiryIdStepOne(accountNumber);
			if (enquiryId != 0) {
				LoanEnquiry loanEnquiry = loanEnquiryDao.getLoanEnquiry(enquiryId);
				loanEnquiry.setProfession(occupationDto.getProfession());
				loanEnquiry.setMonthlyIncome(occupationDto.getMonthlyIncome());
				loanEnquiry=loanEnquiryDao.saveLoanEnquiry(loanEnquiry);
				loanEnquiryStepProcess = applicationContext.getBean(LoanEnquiryStepProcess.class);
				loanEnquiryStepProcess.setAccountNumber(accountNumber);
				loanEnquiryStepProcess.setCompleted(true);
				loanEnquiryStepProcess.setLoanEnquiryid(enquiryId);
				loanEnquiryStepProcess.setStepCount(2);
				loanEnquiryStepProcessDao.saveEnquiryStepProcess(loanEnquiryStepProcess);
				return loanEnquiry;
			}
			throw new LoanEnquiryIdDoesNotExist("Enquiry ID does not Exist");
		}
		throw new AccountNumberNotFound("Step 1 is not completed");

	}

}
