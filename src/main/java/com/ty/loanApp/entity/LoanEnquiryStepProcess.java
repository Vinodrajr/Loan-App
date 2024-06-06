package com.ty.loanApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class LoanEnquiryStepProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int processId;
	@Min(1)
	@Max(5)
	private int stepCount;
	private boolean isCompleted;
	private String accountNumber ;
	private long loanEnquiryid;

}
