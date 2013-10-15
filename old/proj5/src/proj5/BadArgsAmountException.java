package proj5;
/**
 * BadArgsAmountException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description An exception class that handles all command line situations.
 */
@SuppressWarnings("serial")
public class BadArgsAmountException extends Exception {

	String message;
	
	//This exception covers too many different instances, so it displays whole
	// message given at exception time.
	public BadArgsAmountException(String message) {
		super(message);
		this.message = message;
	}

}
