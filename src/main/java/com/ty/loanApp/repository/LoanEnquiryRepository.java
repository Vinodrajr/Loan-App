package com.ty.loanApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryRepository extends JpaRepository<LoanEnquiry, Long> {
	
	public LoanEnquiry findByAccountnumber(String accountnumber);

}
