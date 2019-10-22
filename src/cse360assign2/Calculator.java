package cse360assign2;

import java.util.ArrayList;

/**
 * 
 * @author Andrew Resto
 * @class CSE360
 * @ASUID 1209975062
 * 
 * This file contains an AddingMachine which is capable of adding and subtracting
 * in a list based implementation.
 */


/**
 * A basic "calculator" class which extends the AddingMachine from assignment2.
 * This implementation extends the pattern used previously and introduces 3 new
 * classes for the respective operations to be applied to the equation history.
 * @author Andrew Resto
 *
 */
public class Calculator extends AddingMachine {
	
	/**
	 * The class which defines the multiplication operation.
	 *
	 */
	static protected class OpMult implements AddingMachine.Operation {
		int val;
		boolean start;
		
		public OpMult(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		
		public int execute(int over) {
			return over * val;
		}
		
		public String toString() {
			return (start? "0 * " : " * ") + String.valueOf(val);
		}
	}
	
	/**
	 * The class which defines the division operation.
	 *
	 */
	static protected class OpDiv implements AddingMachine.Operation {
		int val;
		boolean start;
		
		public OpDiv(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		
		public int execute(int over) {
			return (val != 0)? over / val : 0;
		}
		
		public String toString() {
			return (start? "0 / " : " / ") + String.valueOf(val);
		}
	}
	
	/**
	 * The class which defines the power operation.
	 *
	 */
	static protected class OpPower implements AddingMachine.Operation {
		int val;
		boolean start;
		
		public OpPower(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		
		public int execute(int over) {
			return (val >= 0)? (int)Math.pow(over, val) : 0;
		}
		
		public String toString() {
			return (start? "0 ^ " : " ^ ") + String.valueOf(val);
		}
	}
	
	/**
	 * Constructor for the Calculator.
	 */
	public Calculator() {
		super();
	}
	
	/**
	 * Multiply a number against the equation.
	 * @param num number to multiply by
	 */
	public void mult(int num) {
		operations.add(new OpMult(num, operations.isEmpty()));
	}
	
	/**
	 * Divide a number against the equation.
	 * @param num number to divide by
	 */
	public void div(int num) {
		operations.add(new OpDiv(num, operations.isEmpty()));
	}
	
	/**
	 * Raise the equation by a number.
	 * @param num number to power by
	 */
	public void power(int num) {
		operations.add(new OpPower(num, operations.isEmpty()));
	}
}