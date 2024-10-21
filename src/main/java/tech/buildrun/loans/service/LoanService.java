package tech.buildrun.loans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tech.buildrun.loans.controller.dto.CustomerLoanRequest;
import tech.buildrun.loans.controller.dto.CustomerLoanResponse;
import tech.buildrun.loans.controller.dto.LoanResponse;
import tech.buildrun.loans.domain.Loan;
import tech.buildrun.loans.domain.LoanType;

@Service
public class LoanService {
	
	public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {
		
		var customer = loanRequest.toCustomer();
		var loan = new Loan(customer);
		
		List<LoanResponse> loans = new ArrayList<>();
		
		if(loan.isPersonalLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInteresRate()));
		}
		
		if(loan.isConsignmentLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInteresRate()));
		}
		
		if(loan.isGuaranteedLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInteresRate()));
		}
		
		return new CustomerLoanResponse(loanRequest.name(), loans);
	}
}
