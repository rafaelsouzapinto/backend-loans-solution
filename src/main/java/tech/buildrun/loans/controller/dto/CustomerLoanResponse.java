package tech.buildrun.loans.controller.dto;

import java.util.List;

public record CustomerLoanResponse(String costumer, List<LoanResponse> loans) {

}
