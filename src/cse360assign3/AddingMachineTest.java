package cse360assign3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddingMachineTest {

	@Test
	void test_cancels_out() {
		var machine = new AddingMachine();
		machine.add(20);
		machine.add(-20);		
		assertTrue( machine.getTotal() == 0 );
	}
	
	@Test
	void test_clear() {
		var machine = new AddingMachine();
		machine.add(20);
		assertTrue( machine.getTotal() == 20 );
		machine.clear();
		assertTrue( machine.getTotal() == 0 );
	}
	
	@Test
	void test_subtracting_negatives() {
		var machine = new AddingMachine();
		machine.subtract(-20);
		machine.subtract(-40);
		machine.subtract(-10);
		assertTrue( machine.getTotal() == 70 );
		machine.clear();
	}	
	
	@Test
	void test_string_output() {
		var machine = new AddingMachine();
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
		var machine = new AddingMachine();
		machine.subtract(-20);
		machine.add(-10);
		machine.add( 30 );
		machine.subtract(0);
		machine.subtract(10);
		machine.add(10);
		
		assertTrue( machine.getTotal() == (20 + -10 + 30 - 0 - 10 + 10) );
	}	
	
	

}
