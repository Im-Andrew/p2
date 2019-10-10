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
	private interface Operation {
		/**
		 * Executes this operation over the existing results.
		 * @param over the results as of yet.
		 */
		abstract public int execute(int over);
		/**
		 * return this operations string according to its place.
		 * @return
		 */
		abstract public String toString();
	}
	
	/**
	 * A class which defines the adding operation.
	 */
	static private class OpAdd implements Operation {
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
	 *
	 */
	static private class OpSubtract implements Operation {
		int val;
		boolean start;
		
		public OpSubtract(int val, boolean start) { 
			this.val = val;
			this.start = start;
		}
		
		public int execute(int over) {
			return val - over;
		}
		
		public String toString() {
			return (start? "0 - " : " - ") + String.valueOf(val);
		}
	}
	
	/**
	 * Class used for building an operation
	 */
	private static class OpFactory {
		/**
		 * Builds an operation given a value and first flag.
		 * @param value operation value
		 * @param first flag for first operation in equation
		 */
		static Operation createOperation(int value, boolean first, boolean negative) {
			if (!negative && value < 0 || negative && value <= 0) 
				return new OpSubtract(Math.abs(value), first);
			return new OpAdd(Math.abs(value), first);
		}
	}
	
	private ArrayList<Operation> operations;
	
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
		int sum = 0;
		for(Operation op : operations) sum = op.execute(sum);
		return sum;
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
		operations.add( OpFactory.createOperation(-value, operations.isEmpty(), true) );
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