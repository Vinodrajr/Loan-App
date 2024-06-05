package com.ty.loanApp.dto;

import com.ty.loanApp.enums.LoanType;
import com.ty.loanApp.enums.Profession;

import lombok.Data;

@Data
public class EnquiryDto {

	private String accountnumber;
	private String branchId;
	private String bankId;
	private double loanAmount;
	private long tenure;
	private String purpose;
	private LoanType loanType;


}
