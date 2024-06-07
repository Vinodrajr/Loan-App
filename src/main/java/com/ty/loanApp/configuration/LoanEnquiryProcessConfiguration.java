package com.ty.loanApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ty.loanApp.entity.LoanEnquiryStepProcess;

@Configuration
public class LoanEnquiryProcessConfiguration {

	@Bean
	@Scope(value = "prototype")
	public LoanEnquiryStepProcess getEnquiryStepProcess() {
		return new LoanEnquiryStepProcess();
	}

}
