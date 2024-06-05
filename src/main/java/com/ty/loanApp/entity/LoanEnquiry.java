package com.ty.loanApp.entity;

import com.ty.loanApp.enums.LoanStatus;
import com.ty.loanApp.enums.LoanType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "loanenquiry")
public class LoanEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanEnquiryId;
	private String accountnumber;
	private String branchId;
	private String bankId;
	private double loanAmount;
	private long tenure;
	private String purpose;
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	@Enumerated(EnumType.STRING)
	private LoanStatus loanStatus ;

}
