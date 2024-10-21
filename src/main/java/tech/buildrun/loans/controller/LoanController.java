package tech.buildrun.loans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.buildrun.loans.controller.dto.CustomerLoanRequest;
import tech.buildrun.loans.controller.dto.CustomerLoanResponse;
import tech.buildrun.loans.service.LoanService;

@RestController
public class LoanController {
	
	private final LoanService service;
	
	public LoanController(LoanService service) {
		this.service = service;
	}

	@PostMapping("/customer-loans")
	public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest loanRequest) {
		var loanResponse = service.checkLoanAvailability(loanRequest);
		return ResponseEntity.ok().body(loanResponse);
	}
	
	
}
