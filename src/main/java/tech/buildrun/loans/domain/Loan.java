package tech.buildrun.loans.domain;

public class Loan {

	private Customer customer;

	public Loan(Customer customer) {
		this.customer = customer;
	}
	
	//PERSONAL
	public boolean isPersonalLoanAvailable() {
		return basicLoanAvailable();
	}
	public double getPersonalLoanInteresRate() {
		if(isPersonalLoanAvailable()) {
			return 4.0;
		}
		throw new LoanNotAvailableException();
	}
	
	//CONSIGNMENT
	public boolean isConsignmentLoanAvailable() {
		return customer.isIncomeEqualOrUpperThan(5000.0);
	}
	public double getConsignmentLoanInteresRate() {
		if(isConsignmentLoanAvailable()) {
			return 2.0;
		}
		throw new LoanNotAvailableException();
	}
	
	//GUARANTEED
	public boolean isGuaranteedLoanAvailable() {
		return basicLoanAvailable();
	}
	public double getGuaranteedLoanInteresRate() {
		if(isGuaranteedLoanAvailable()) {
			return 3.0;
		}
		throw new LoanNotAvailableException();
	}
	
	//Basic loan calculator
	private boolean basicLoanAvailable() {
		if (customer.isIncomeEqualOrLowerThan(3000.0)) {
			return true;
		}
		return customer.isIncomeBetween(3000.0, 5000.0)
				&& customer.isAgeLowerThan(30)
				&& customer.isFromLocation("SP");
	}
}
