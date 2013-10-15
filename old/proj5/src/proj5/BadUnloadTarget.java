package proj5;
/**
 * BadUnloadTarget.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception class handling any bad pointers/references 
 * within the UNLOAD method.
 */
@SuppressWarnings("serial")
public class BadUnloadTarget extends Exception {

	public BadUnloadTarget(String message){
		super(message);
	}
	
	public BadUnloadTarget(String element_ID, int boxcar_ID ){
		super(String.format("Warning: No corresponding ID found in " +
				"boxcar %d that matches %s. ", boxcar_ID, element_ID));
	}

	public BadUnloadTarget(int boxcar_ID, int list_size){
		super(String.format("Warning: Boxcar ID given(%d) is invalid for the " +
				"boxcars list size(%d)", boxcar_ID, list_size ));
	}
}
