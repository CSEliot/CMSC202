package proj5;
/**
 * IllogicalActionException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception class handling any logical fallacies.
 */
@SuppressWarnings("serial")
public class IllogicalActionException extends Exception{
	
	public IllogicalActionException(String message) {
		super(message);
	}

}
