package com.ty.loanApp.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private int statusCode;
	private String message;
}
