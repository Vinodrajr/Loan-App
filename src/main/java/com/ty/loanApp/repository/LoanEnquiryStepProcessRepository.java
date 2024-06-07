package com.ty.loanApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

public interface LoanEnquiryStepProcessRepository extends JpaRepository<LoanEnquiryStepProcess, Integer> {

	@Query("SELECT EXISTS (FROM LoanEnquiryStepProcess l WHERE l.accountNumber= :accountNumber AND l.stepCount = :stepCount)")
	public boolean loanEnnquiryStepIsCompleted(String accountNumber, int stepCount);

	@Query("SELECT l.loanEnquiryid FROM LoanEnquiryStepProcess l WHERE l.accountNumber= :accountNumber AND l.stepCount=1")
	Long getLoanEquiryIdStepOne(String accountNumber);

}
