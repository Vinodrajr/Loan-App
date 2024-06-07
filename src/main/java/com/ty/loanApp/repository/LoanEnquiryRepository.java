package com.ty.loanApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.loanApp.entity.LoanEnquiry;

public interface LoanEnquiryRepository extends JpaRepository<LoanEnquiry, Long> {
	
	public LoanEnquiry findByAccountnumber(String accountnumber);

	public List<LoanEnquiry> findAllByBankId(String bankId);
	
	public List<LoanEnquiry> findAllByBranchId(String branchId);
	
	@Query("SELECT EXISTS (FROM LoanEnquiry a WHERE a.bankId = :bankId)")
	public boolean checkLoanEnquiryByBankId(String bankId);
	
	@Query("SELECT EXISTS (FROM LoanEnquiry a WHERE a.branchId = :branchId)")
	public boolean checkLoanEnquiryByBranchId(String branchId);
	
	
	

}
