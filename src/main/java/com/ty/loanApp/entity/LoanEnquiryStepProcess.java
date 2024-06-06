package com.ty.loanApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LoanEnquiryStepProcess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int processId ;
	private int stepCount ;
	private boolean isCompleted ;
	private String accountNumber ;

}
