package tech.buildrun.loans.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tech.buildrun.loans.factory.CustomerFactory;

class CustomerTest {

	
	@Nested
	class isIncomeEqualOrLowerThan {
		
		@Test
		void shouldBeTrueWhenIncomeIsEqual() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeEqualOrLowerThan(5000.00));
		}
		
		@Test
		void shouldBeTrueWhenIncomeIsLowerThanValue() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeEqualOrLowerThan(9000.0));
		}
		
		@Test
		void shouldBeFalseWhenIncomeIsUpperThanValue() {
			var customer = CustomerFactory.build(5000.0);
			
			assertFalse(customer.isIncomeEqualOrLowerThan(3000.00));
		}
	}
	
	@Nested
	class isIncomeEqualOrUpperThan {
		
		@Test
		void shouldBeTrueWhenIncomeIsEqual() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeEqualOrUpperThan(5000.0));
		}
		
		@Test
		void shouldBeTrueWhenIncomeIsUpperThanValue() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeEqualOrUpperThan(4000.0));
		}
		
		@Test
		void shouldBeFalseWhenIncomeIsLowerThanValue() {
			var customer = CustomerFactory.build(5000.0);
			
			assertFalse(customer.isIncomeEqualOrUpperThan(8000.0));
		}
	}	
		
	@Nested
	class isIncomeBetween {
		
		@Test
		void shouldBeTrueWhenIncomeIsBetween() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
		}
		
		@Test
		void shouldBeTrueWhenIncomeIsEqualToMin() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeBetween(5000.0, 8000.0));
		}	
		
		@Test
		void shouldBeTrueWhenIncomeIsEqualToMax() {
			var customer = CustomerFactory.build(5000.0);
			
			assertTrue(customer.isIncomeBetween(3000.0, 5000.0));
		}
		
		@Test
		void shouldBeFalseWhenIncomeIsNotBetween() {
			var customer = CustomerFactory.build(5000.0);
			
			assertFalse(customer.isIncomeBetween(4000.0, 4500.0));
		}	
	}
	
	@Nested
	class isAgeLowerThan {
		
		@Test
		void shouldBeTrueWhenAgeIsLowerThan() {
			var customer = CustomerFactory.build(25);
			
			assertTrue(customer.isAgeLowerThan(30));
		}
		
		@Test
		void shouldBeFalseWhenAgeIsUpperThan() {
			var customer = CustomerFactory.build(25);
			
			assertFalse(customer.isAgeLowerThan(20));
		}
		
		@Test
		void shouldBeFalseWhenAgeIsEqualThan() {
			var customer = CustomerFactory.build(25);
			
			assertFalse(customer.isAgeLowerThan(25));
		}
	}
	
	@Nested
	class isFromLocation {
		
		@Test
		void shouldBeTrueWhenLocationIsTheSame() {
			var customer = CustomerFactory.build("SP");
			
			assertTrue(customer.isFromLocation("SP"));
		}
		
		@Test
		void shouldBeFalseWhenLocationIsNotTheSame() {
			var customer = CustomerFactory.build("SP");
			
			assertFalse(customer.isFromLocation("RJ"));
		}
	}
	
}
