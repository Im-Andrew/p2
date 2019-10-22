package cse360assign3;

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
 * This class will add or subtract numbers after executing the final sequence of operations..
 * It can also display the operation sequence as a string.
 * It simplifies the problem of signs.
 * example: - -1 becomes + 1, adding(-1) becomes - 1 
 * @author Andrew Resto
 *
 */
public class AddingMachine {
	
	/**
	 * An interface used to describe an equation operation.
	 */
	static protected interface Operation {
		/**
		 * Executes this operation over the existing results.
		 * @param over the results as of yet.
		 */
		public int execute(int over);
		/**
		 * return this operations string according to its place.
		 * @return
		 */
		public String toString();
	}
	
	/**
	 * A class which defines the adding operation.
	 */
	static protected class OpAdd implements Operation {
		int val;
		boolean start;
		public OpAdd(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		public int execute(int over) {
			return val + over;
		}
		public String toString() {
			return (start? "0 + " : " + ") + String.valueOf(val);
		}
	}
	
	/**
	 * The class which defines the subtraction operation.
	 */
	static protected class OpSubtract implements Operation {
		int val;
		boolean start;
		
		public OpSubtract(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		
		public int execute(int over) {
			return over - val;
		}
		
		public String toString() {
			return (start? "0 - " : " - ") + String.valueOf(val);
		}
	}
	
	/**
	 * Class used for building an operation
	 */
	protected static class OpFactory {
		/**
		 * Builds an operation given a value and first flag.
		 * @param value operation value
		 * @param first flag for first operation in equation
		 */
		static Operation createOperation(int val, boolean first, boolean neg) {
			Operation op;
			// If adding and is negative or negative 
			if ((!neg && val < 0) || (neg && val >= 0)) {
				op = new OpSubtract(Math.abs(val), first);
			} else {				
				op = new OpAdd(Math.abs(val), first);
			}
			return op;
		}
	}
	
	protected ArrayList<Operation> operations;
	
	/**
	 * Constructor for the adding machine.
	 */
	public AddingMachine() {
		operations = new ArrayList<Operation>();
	}
	
	/**
	 * Returns all the numbers added together.
	 * @return final computation
	 */
	public int getTotal() {
		int eqVal = 0;
		for(Operation op : operations) eqVal = op.execute(eqVal);
		return eqVal;
	}
	
	/**
	 * Add a number to the equation.
	 * @param value number to add
	 */
	public void add(int value) {
		operations.add( OpFactory.createOperation(value, operations.isEmpty(), false) );
	}
	
	/**
	 * Subtract a number from the equation.
	 * @param value number to subtract.
	 */
	public void subtract (int value) {
		operations.add( OpFactory.createOperation(value, operations.isEmpty(), true) );
	}
		
	/**
	 * Converts the equation into its string representation.
	 */
	public String toString() {
		StringBuilder b = new StringBuilder();
		for(Operation op : operations ) b.append(op.toString());
		return b.toString();
	}

	/**
	 * Resets the equation to be used for another equation.
	 */
	public void clear() {
		operations.clear();
	}
}