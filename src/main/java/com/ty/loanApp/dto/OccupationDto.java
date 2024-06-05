package com.ty.loanApp.dto;

import com.ty.loanApp.enums.Profession;

import lombok.Data;

@Data
public class OccupationDto {
	
	private String accountnumber ;
	private Profession profession;
	private double monthlyIncome ;

}
