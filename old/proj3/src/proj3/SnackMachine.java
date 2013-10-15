package proj3;

import java.awt.Color;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * SnackMachine.java
 * @version 11/12/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 * 
 * Class Invariants:
 * 1. Mint and Cookie costs will never change from 0.35 and 0.65.
 * 2. Max Mint storage and max Cookie storage will never change from 75 and 60.
 */
public class SnackMachine {

	private Mints mint;
	private Cookies cookie;
	private ArrayList<Color> mintStorage = new ArrayList<Color>(75);
	private ArrayList<CookieFlavors> cookieStorage = 
		new ArrayList<CookieFlavors>(60);
	private Money regMoney = new Money(0,0,0);
	private final BigDecimal MINT_COST = new BigDecimal("0.35");
	private final BigDecimal COOKIE_COST = new BigDecimal("0.65");
	

	/** Grabs a mint from the bottom of the stack and removes it, lowering all
	 * 	other mints in the list down 1 level. Sends cost of mint to 
	 *  SnackMachine's register money object regMoney, and returns the mint.
	 *  
	 *  pre-conditions: money entered = mint cost, and SnackMachine has a mint,
	 *  				else, returns null.
	 * 	post-conditions: mint from bottom of stack mintStorage removed, cash
	 * 					 added to regMoney.
	 * 
	 * @param money - holds all temporary cash payed by customer. 
	 * @return null - if pre-condition violated, else, mint - Mint object containing color. 
	 */
	public Mints buyMints(Money money) {
		
		
		
		/*System.out.println("Payed total: " + money.getTotal());
		TrueChange = new BigDecimal(money.getTotal());
		trueChange = trueChange.setScale(2,BigDecimal.ROUND_HALF_UP);
		trueChange = trueChange.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		System.out.println("FIXED PAY: " + trueChange.toString());*/
		
		
		if(money.getTotal().compareTo(MINT_COST) != 0 || mintStorage.size() <= 0)
		{
			//System.out.println("Compare: null");
			return null;
		}
		else
		{
			//System.out.println("Compare: Success");
			mint = new Mints(mintStorage.get(mintStorage.size() - 1));
			removeMints();
			cashRegister(money);
			return mint;
		}
		
		
	}

	/** Grabs a cookie from the bottom of the stack and removes it, lowering all
	 * 	other cookies in the list down 1 level. Sends cost of cookie to 
	 *  SnackMachine's register money object regMoney, and returns the cookie.
	 *  
	 *  pre-conditions: money entered = cookie cost, and SnackMachine has a cookie,
	 *  				else, returns null.
	 * 	post-conditions: cookie from bottom of stack cookieStorage removed, cash
	 * 					 added to regMoney.
	 * 
	 * @param money - holds all temporary cash payed by customer. 
	 * @return null - if pre-condition violated, else, cookie - cookie object containing color. 
	 */
	public Cookies buyCookies(Money money) {
		
		if(money.getTotal().compareTo(COOKIE_COST) != 0 || cookieStorage.size() <= 0)
		{
			//System.out.println("Compare: null");
			return null;
		}
		else
		{
			//System.out.println("Compare: Success");
			cookie = new Cookies(cookieStorage.get(cookieStorage.size() - 1));
			removeCookies();
			cashRegister(money);
			return cookie;
		}
		
	}

	/** uses a do-while to add cookie to the bottom of the stack of cookies.
	 *  pre-conditions: No nulls, nrMints can't be 0 or less.
	 * 	post-conditions: cookieStorage size is larger by nrCookies amount.
	 * 
	 * @param cFlavor - Flavor object containing flavor enumerated. 
	 * @param nrCookies - Number of cookies added to stack.
	 * 
	 */
	public void addCookies(CookieFlavors cFlavor, int nrCookies) 
	{
		//Test Cases for Exceptions.
		if(cFlavor == null)
		{
			throw new RuntimeException("Flavor is Null");
		}
		else if(nrCookies <= 0)
		{
			throw new RuntimeException("nrCookies cannot be 0 or less.");
		}
		else if(cookieStorage.size() + nrCookies > 60)
		{
			throw new RuntimeException("Attempted to add too many Cookies");
		}
		
		
		do
		{	
		cookieStorage.add(0, cFlavor);
		nrCookies--;
		}
		while(nrCookies != 0);
		
	}

	/** uses a do-while to add mints to the bottom of the stack of mints.
	 * 
	 *  pre-conditions: No nulls, nrMints can't be 0 or less.
	 * 	post-conditions: mintStorage size is larger by nrMints amount.
	 * 
	 * @param mColor - Color object containing mint color. 
	 * @param nrMints - Number of mints to be added.
	 */		
	public void addMints(Color mColor, int nrMints) {
		//Test Cases for Exceptions.
		if(mColor == null)
		{
			throw new RuntimeException("Color is Null");
		}
		else if(nrMints <= 0)
		{
			throw new RuntimeException("Number of mints (nrMints) cannot be 0 or less.");
		}
		else if(mintStorage.size() + nrMints > 75)
		{
			throw new RuntimeException("Maximum number of mints exceeded.");
		}
		
		//Pushes Mint onto top of stack(0) and all others up one
		//until all mints have been stacked.
		do
		{	
		mintStorage.add(0, mColor);
		nrMints--;
		}
		while(nrMints > 0);
		
		
		
		/*	
		System.out.println(""+mColor.getRGB());
		System.out.println(""+mColor.getRed());
		System.out.println(""+mColor.getGreen());
		System.out.println(""+mColor.getBlue());
		System.out.println(mintStorage.toString());
		*/
	}

	public int getNrMints() 
	{
		return mintStorage.size();
	}

	public int getNrCookies() 
	{
		return cookieStorage.size();
	}

	public Money getCashOnHand()
	{
		return regMoney;
	}

	//-- helper methods
	private final void removeMints()
	{
		mintStorage.remove(mintStorage.size() -1);
	}
	private void removeCookies() 
	{
		cookieStorage.remove(cookieStorage.size() -1);
	}

	/** A helper method that adds money to the Money object named regMoney
	 * which means register Money. This holds all final money values obtained
	 * by purchases.
	 * 
	 * pre-condition: NONE
	 * post-condition: regMoney's variables now have larger attributes.
	 * 
	 * @param money - temporary holder of inserted cash.
	 */
	private final void cashRegister(Money money)
	{
		
		regMoney.addNrDimes(money.getNrDimes());
		regMoney.addNrNickels(money.getNrNickels());
		regMoney.addNrQrters(money.getNrQrters());
		regMoney.addTotal(money.getTotal());
		
	}
	
	public static void main (String [] args)
	{
		SnackMachine snckMchnTest = new SnackMachine();


		final Color RED = new Color(255, 0, 0);
		final Color BLUE = new Color(0, 0, 255);
		final Color GREEN = new Color(0, 255, 0);
		snckMchnTest.addMints(RED, 3);
		snckMchnTest.addMints(GREEN, 2);
		snckMchnTest.addMints(BLUE, 4);
		System.out.println("Number of mints: " + snckMchnTest.getNrMints());
		
		//Testing max mint storage
		//snckMchnTest.addMints(GREEN, 50);
		
		snckMchnTest.buyMints(new Money(0, 1, 1));
		snckMchnTest.buyMints(new Money(2, 0, 1));
		snckMchnTest.buyMints(new Money(7, 0, 0));
		snckMchnTest.buyMints(new Money(5, 1, 0));
		snckMchnTest.buyMints(new Money(3, 2, 0));
		snckMchnTest.buyMints(new Money(1, 3, 0));
		snckMchnTest.buyMints(new Money(7, 0, 0));
		snckMchnTest.buyMints(new Money(0, 1, 1));
		snckMchnTest.buyMints(new Money(0, 1, 1));
		
		System.out.println("Number of mints: " + snckMchnTest.getNrMints());
		System.out.println("getCashOnHand: " + snckMchnTest.getCashOnHand());
		
		snckMchnTest.addCookies(CookieFlavors.CHOCOLATE_CHIP, 1);
		snckMchnTest.addCookies(CookieFlavors.OATMEAL, 1);
		snckMchnTest.addCookies(CookieFlavors.LEMON, 1);
		System.out.println("Number of Cookies: " + snckMchnTest.getNrCookies());
		
		//Testing max cookie storage
		//snckMchnTest.addCookies(CookieFlavors.LEMON, 100);

		snckMchnTest.buyCookies(new Money(1, 1, 2));
		snckMchnTest.buyCookies(new Money(13, 0, 0));
		snckMchnTest.buyCookies(new Money(1, 6, 0));
		
		System.out.println("Number of Cookies: " + snckMchnTest.getNrCookies());
		System.out.println("getCashOnHand: " + snckMchnTest.getCashOnHand());

		
		
		
		System.out.println("Hey There! We're Done Testing SnackMachine!");
		
		
		
		
	}
}
