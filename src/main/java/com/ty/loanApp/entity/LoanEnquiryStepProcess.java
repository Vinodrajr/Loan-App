package com.ty.loanApp.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class LoanEnquiryStepProcess {

	private int processId;
	@Min(1)
	@Max(5)
	private int stepCount;
	private boolean isCompleted;
	private String accountNumber;

}
