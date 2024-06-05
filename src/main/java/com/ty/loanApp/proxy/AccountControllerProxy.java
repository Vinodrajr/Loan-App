package com.ty.loanApp.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.loanApp.util.ResponseStructure;

@FeignClient(name = "bank")
public interface AccountControllerProxy {

	@GetMapping("/api/version/v1/accounts/checkAccountNumber")
	public ResponseEntity<ResponseStructure<Boolean>> checkAccountNumberExist(@RequestParam String accountNumber);

}
