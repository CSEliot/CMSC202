package proj5;
/**
 * SpeedMaxExtentionException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception handling attempts to set the speed above the maximum.
 */
@SuppressWarnings("serial")
public class SpeedMaxExtentionException extends Exception {

	public SpeedMaxExtentionException(int current_speed, int increased_by,
			int max_speed){
		super(String.format("Warning: Target speed(%dmph) " +
				"is greater than max speed(%dmph). Action skipped."
				,current_speed+increased_by, max_speed));
		
	}

}
