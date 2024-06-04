package com.ty.loanApp.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.loanApp.dao.LoanEnquiryDao;
import com.ty.loanApp.entity.LoanEnquiry;
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

}
