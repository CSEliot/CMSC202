package proj5;
/**
 * FullBoxcarException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception class to catch attempts to LOAD a full boxcar.
 */
@SuppressWarnings("serial")
public class FullBoxcarException extends Exception {
	
	int maxed_boxcar;

	public FullBoxcarException(int maxed_boxcar) {
		super(String.format("Warning: Maximum number of elements(%d) reached. Action skipped.", maxed_boxcar));
		this.maxed_boxcar = maxed_boxcar;
	}

}
