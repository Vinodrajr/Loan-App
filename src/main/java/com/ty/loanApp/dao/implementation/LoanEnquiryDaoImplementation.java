package com.ty.loanApp.dao.implementation;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.entity.LoanEnquiry;
import com.ty.loanApp.exception.AccountNumberNotFound;
import com.ty.loanApp.exception.BranchIdDoesNotExist;
import com.ty.loanApp.exception.LoanEnquiryIdDoesNotExist;
import com.ty.loanApp.repository.LoanEnquiryRepository;


@Repository
public class LoanEnquiryDaoImplementation implements LoanEnquiryDao {

	@Autowired
	private LoanEnquiryRepository repository;

	public LoanEnquiryDaoImplementation(LoanEnquiryRepository repository) {
		this.repository = repository;
	}

	public LoanEnquiry saveLoanEnquiry(LoanEnquiry loanEnquiry) {
		return repository.save(loanEnquiry);
	}

	@Override
	public LoanEnquiry getLoanEnquiryByAccountNumber(String accountnumber) {
		LoanEnquiry enquiry=repository.findByAccountnumber(accountnumber);
		if(enquiry!=null)
			return enquiry;
		throw new AccountNumberNotFound("Account number Not Found");
	}

	@Override
	public String deleteLoanEnquiryByEnquiryId(long loanEnquiryId) {
		Optional<LoanEnquiry> op = repository.findById(loanEnquiryId);
		if(op.isPresent())
		{
			repository.delete(op.get());
			return "DELETED";
		}
		throw new LoanEnquiryIdDoesNotExist("Loan Enquiry ID Not Found");

	}

	@Override
	public String deleteLoanEnquiryByBankId(String bankId) {
		List<LoanEnquiry> list_loanEnquiry = repository.findAllByBankId(bankId);
		if(!list_loanEnquiry.isEmpty())
		{
			Iterator<LoanEnquiry> itr = list_loanEnquiry.iterator();
			while(itr.hasNext())
			{
				LoanEnquiry l = itr.next();
				repository.delete(l);
			}
			return "DELETED";
		}
		throw new BranchIdDoesNotExist("Bank ID Not Found");
	}

	@Override
	public String deleteLoanEnquiryByBranchId(String branchId) {
		List<LoanEnquiry> list_loanEnquiry = repository.findAllByBranchId(branchId);
		if(!list_loanEnquiry.isEmpty())
		{
			Iterator<LoanEnquiry> itr = list_loanEnquiry.iterator();
			while(itr.hasNext())
			{
				LoanEnquiry l = itr.next();
				repository.delete(l);
			}
			return "DELETED";
		}
		throw new BranchIdDoesNotExist("Branch ID Not Found");
	}

	@Override
	public List<LoanEnquiry> getLoanEnquiryByBankId(String bankId) {
		List<LoanEnquiry> listEnquiries=repository.findAllByBankId(bankId);
		if(!listEnquiries.isEmpty())
			return listEnquiries;
		throw new BranchIdDoesNotExist("Bank ID does not exist");
	}

	@Override
	public List<LoanEnquiry> getLoanEnquiryByBranchId(String branchId) {
		List<LoanEnquiry> listEnquiries=repository.findAllByBranchId(branchId);
		if(!listEnquiries.isEmpty())
			return listEnquiries;
		throw new BranchIdDoesNotExist("Branch ID does not exist");

	}

	@Override
	public boolean checkLoanEnquiryByBankId(String bankId) {
		return repository.checkLoanEnquiryByBankId(bankId);
	}

	@Override
	public boolean checkLoanEnquiryByBranchId(String branchId) {
		return repository.checkLoanEnquiryByBranchId(branchId);
	}

}
