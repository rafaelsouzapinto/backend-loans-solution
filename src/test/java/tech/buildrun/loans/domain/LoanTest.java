package tech.buildrun.loans.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoanTest {

	@Mock
	private Customer customer;
	
	@InjectMocks
	private Loan loan;
	
	@Nested
	class isPersonalLoanAvailable {
		
		@Test
		void sholdBeAvailableWhenIncomeIsEqualOrLess3k() {
			
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertTrue(loan.isPersonalLoanAvailable());
		}
		
		@Test
		void sholdBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {
			
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
			doReturn(true).when(customer).isAgeLowerThan(30);
			doReturn(true).when(customer).isFromLocation("SP");
			
			assertTrue(loan.isPersonalLoanAvailable());
		}
	}
	
	@Nested
	class isGuaranteedLoanAvailable {
		
		@Test
		void sholdBeAvailableWhenIncomeIsEqualOrLess3k() {
			
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertTrue(loan.isGuaranteedLoanAvailable());
		}
		
		@Test
		void sholdBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSP() {
			
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			doReturn(true).when(customer).isIncomeBetween(3000.0, 5000.0);
			doReturn(true).when(customer).isAgeLowerThan(30);
			doReturn(true).when(customer).isFromLocation("SP");
			
			assertTrue(loan.isGuaranteedLoanAvailable());
		}
	}
	
	@Nested
	class isConsignmentLoanAvailable {
		
		@Test
		void sholdBeAvailableWhenIncomeIsEqualOrUpperThan5k() {
			
			doReturn(true).when(customer).isIncomeEqualOrUpperThan(5000.0);
			
			assertTrue(loan.isConsignmentLoanAvailable());
		}
		
		@Test
		void sholdNotBeAvailableWhenIncomeIsEqualto4k() {
			
			doReturn(false).when(customer).isIncomeEqualOrUpperThan(5000.0);
			
			assertFalse(loan.isConsignmentLoanAvailable());
		}
	}
	
	@Nested
	class getPersonalLoanInteresRate {
		
		@Test
		void sholdBeInterestRateBe4() {
			
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertEquals(4.0, loan.getPersonalLoanInteresRate());
		}
		
		@Test
		void sholdThrowExceptionWhenIsNotAvailable() {
			
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInteresRate());
		}
	}
	
	@Nested
	class getGuaranteedLoanInteresRate {
		
		@Test
		void sholdBeInterestRateBe3() {
			
			doReturn(true).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertEquals(3.0, loan.getGuaranteedLoanInteresRate());
		}
		
		@Test
		void sholdThrowExceptionWhenIsNotAvailable() {
			
			doReturn(false).when(customer).isIncomeEqualOrLowerThan(3000.0);
			
			assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInteresRate());
		}
	}
	
	@Nested
	class getConsignmentLoanInteresRate {
		
		@Test
		void sholdBeInterestRateBe2() {
			
			doReturn(true).when(customer).isIncomeEqualOrUpperThan(5000.0);
			
			assertEquals(2.0, loan.getConsignmentLoanInteresRate());
		}
		
		@Test
		void sholdThrowExceptionWhenIsNotAvailable() {
			
			doReturn(false).when(customer).isIncomeEqualOrUpperThan(5000.0);
			
			assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInteresRate());
		}
	}
}
