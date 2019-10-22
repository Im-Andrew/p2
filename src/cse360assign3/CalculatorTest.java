package cse360assign3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test_cancels_out() {
		var machine = new Calculator();
		machine.add(20);
		machine.add(-20);		
		assertTrue( machine.getTotal() == 0 );
	}
	
	@Test 
	void test_add_negative() {
		var machine = new Calculator();
		machine.add(-5);
		assertTrue( machine.getTotal() == -5 );
		machine.subtract(5);
		var a = machine.getTotal();
		var b = machine.toString();
		assertTrue( machine.getTotal() == -10 );
	}
	
	@Test
	void test_clear() {
		var machine = new Calculator();
		machine.add(20);
		assertTrue( machine.getTotal() == 20 );
		machine.clear();
		assertTrue( machine.getTotal() == 0 );
	}
	
	@Test
	void test_subtracting_negatives() {
		var machine = new Calculator();
		machine.subtract(-20);
		machine.subtract(-40);
		machine.subtract(-10);
		assertTrue( machine.getTotal() == 70 );
		machine.clear();
	}	
	
	@Test
	void test_string_output() {
		var machine = new Calculator();
		machine.subtract(-20);
		machine.add(-10);
		machine.add( 30 );
		machine.subtract(0);
		machine.subtract(10);
		machine.add(10);

		assertTrue( machine.toString().equals("0 + 20 - 10 + 30 - 0 - 10 + 10") );
	}	

	
	@Test
	void test_final() {
		var machine = new Calculator();
		machine.subtract(-20);
		machine.add(-10);
		machine.add( 30 );
		machine.subtract(0);
		machine.subtract(10);
		machine.add(10);
		
		assertTrue( machine.getTotal() == (20 + -10 + 30 - 0 - 10 + 10) );
	}	
	
	@Test
	void test_multiplication() {
		var calc = new Calculator();
		calc.add(20);
		calc.mult(2);
		
		assertTrue( calc.getTotal() == 40 );

		calc.mult(-2);
		
		assertTrue( calc.getTotal() == -80 );
		
		calc.mult(-2);
		
		assertTrue( calc.getTotal() == 160 );

		calc.mult(0);
		
		assertTrue( calc.getTotal() == 0 );
		
		calc.add(100);
		calc.mult(1);
		
		assertTrue( calc.getTotal() == 100 );
		
		calc.add(100);
		calc.mult(5);
		
		assertTrue( calc.getTotal() == 1000 );
	}
	
	@Test
	void test_division() {
		var calc = new Calculator();
		calc.add(20);
		calc.div(2);
		
		assertTrue( calc.getTotal() == 10 );

		calc.div(2);
		
		assertTrue( calc.getTotal() == 5 );
		
		calc.div(2);
		
		assertTrue( calc.getTotal() == 2 );

		calc.div(2);
		
		assertTrue( calc.getTotal() == 1 );
		
		calc.div(2);
		
		assertTrue( calc.getTotal() == 0 );
		
		calc.div(2123);
		
		assertTrue( calc.getTotal() == 0 );
		
		calc.add(100);
		
		calc.div(-5);
		
		assertTrue( calc.getTotal() == -20 );
		
		calc.div(0);
		
		assertTrue( calc.getTotal() == 0 );
	}
	
	@Test
	void test_power() {
		var calc = new Calculator();
		calc.add(5);
		calc.power(2);
		
		assertTrue( calc.getTotal() == 25 );
		
		calc.clear();
		
		calc.add(5);
		calc.power(3);;
		
		assertTrue( calc.getTotal() == 125 );
		
		calc.clear();
		calc.add(-5);
		calc.power(2);

		assertTrue( calc.getTotal() == 25 );
		
		calc.clear();
		calc.add(-5);
		calc.power(3);

		assertTrue( calc.getTotal() == -125 );
		
		calc.clear();
		calc.add(2);
		calc.power(10);
		
		assertTrue( calc.getTotal() == 1024 );
	}
	
	@Test
	void test_all() {
		var calc = new Calculator();
		calc.add(5);
		calc.power(2);
		
		calc.clear();
		
		calc.add(40);			// 40
		calc.add(-60);			// 40 + -60 = -20
		calc.mult(5);			// -20 * 5 = -100
		calc.div(-10);			// -100/-10 = 10
		calc.subtract(9);		// 10 - 9 = 1
		calc.subtract(-1);		// 1 - -1 = 2
		calc.power(3);			// 2^3 = 2 * 2 * 2 = 8
		
		assertTrue( calc.getTotal() == 8 );
		assertTrue( calc.toString().equals("0 + 40 - 60 * 5 / -10 - 9 + 1 ^ 3"));
		
	}

}
