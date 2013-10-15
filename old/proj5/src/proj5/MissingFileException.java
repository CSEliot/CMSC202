package proj5;
import java.io.FileNotFoundException;
/**
 * MissingFileException.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description Exception class for given file in/out is not found.
 * Exception thrown but not caught. Unchecked.
 */
@SuppressWarnings("serial")
public class MissingFileException extends FileNotFoundException {
	String filename;
	
	public MissingFileException(String filename) {
		super(filename);
		this.filename = String.format("Filename %s " +
				"does not exist.",filename );
		
	}

}
