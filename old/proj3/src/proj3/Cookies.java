package proj3;
/**
 * Cookies.java
 * @version 11/12/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 * 
 * Class Invariants: none
 */
public class Cookies {

	private CookieFlavors cookieFlavor;
	
	public Cookies(CookieFlavors cookieFlavor) 
	{
		this.cookieFlavor = cookieFlavor;
	}


	public String getFlavor() {
		
		String str = "" + cookieFlavor;
		return str;
	}
	
	public String toString()
	{
		String str = "Cookie Color: " + cookieFlavor;
		return str;
			
	}

	public static void main (String [] args)
	{
		Cookies cksTest0 = new Cookies(CookieFlavors.LEMON);
		Cookies cksTest1 = new Cookies(CookieFlavors.CHOCOLATE_CHIP);
		Cookies cksTest2 = new Cookies(CookieFlavors.OATMEAL);
		
		
		System.out.println(cksTest0.getFlavor());
		System.out.println(cksTest1.getFlavor());
		System.out.println(cksTest2.getFlavor());
	
		cksTest0.toString();
		cksTest1.toString();
		cksTest2.toString();
		
		System.out.println("Hey There! We're Done Testing Cookies.java");

	}
}

