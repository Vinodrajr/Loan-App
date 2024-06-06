package com.ty.loanApp.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class LoanEnquiryStepProcess {
	
	private int processId ;
	private int stepCount ;
	private boolean isCompleted ;
	private String accountNumber ;

}
