package proj3;

/**
 * Mints.java
 * @version 11/12/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 * 
 * Class Invariants: none
 */
import java.awt.Color;

public class Mints {

	Color mColor;
	
	public Mints(Color mColor)
	{
		this.mColor = mColor;
	}
	
	public Color getColor() {
		
		return mColor;
	}


	public String toString()
	{
		String str = "Mint Color: " + mColor;
		return str;
			
	}
	
	public static void main (String [] args)
	{
		Mints mntsTest0 = new Mints(Color.RED);
		Mints mntsTest1 = new Mints(Color.GREEN);
		Mints mntsTest2 = new Mints(Color.BLUE);
		
		
		
		System.out.println(mntsTest0.getColor());
		System.out.println(mntsTest1.getColor());
		System.out.println(mntsTest2.getColor());
	
		mntsTest0.toString();
		mntsTest1.toString();
		mntsTest2.toString();
		
		System.out.println("Hey There! We're Done Testing Mints.java");

	}
	
}
