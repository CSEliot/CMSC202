package proj5;
/**
 * SpeedMinExtentionException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception class that handled attempts at setting the speed below the minimum.
 */
@SuppressWarnings("serial")
public class SpeedMinExtentionException extends Exception {

	public SpeedMinExtentionException(int current_speed, int decreased_by,
			int min_speed) {
		super(String.format("Warning: Target speed(%dmph) " +
				"is lesser than min speed(%dmph). Action skipped."
				,current_speed-decreased_by, min_speed));
		}

}
