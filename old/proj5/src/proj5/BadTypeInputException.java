package proj5;
/**
 * BadTypeInputException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description An exception class that handles references from 
 * one type to another for Boxcar.
 */
@SuppressWarnings("serial")
public class BadTypeInputException extends Exception {
	
	Object boxcar;
	Object bad_element;
	
	public BadTypeInputException(Object boxcar, Object bad_element) {
		super(String.format("Warning: Invalid element(%s) inserted into " +
				"boxcar(%s). Action Skipped.", bad_element.toString(),
				boxcar.toString() ));
		this.boxcar = boxcar;
		this.bad_element = bad_element;
	}

}
