package proj3;

import java.math.BigDecimal;

/**
 * Money.java
 * @version 11/12/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 * 
 * Class Invariants: none
 */
public class Money {
	private int nrNickels = 0;
	private int nrDimes = 0;
	private int nrQrters = 0;
	private BigDecimal total;
	
	/**
	 * Constructor Method. Makes a call to helper method setTotal
	 * in order to keep the constructor from looking messy.
	 * 
	 * @param nrNickels - Number of Nickels
	 * @param nrDimes - Number of Dimes
	 * @param nrQrts - Number of Quarters
	 */
	public Money(int nrNickels, int nrDimes, int nrQrts) 
	{
		this.nrNickels += nrNickels;
		this.nrDimes += nrDimes;
		this.nrQrters += nrQrts;
		//Instead of using double, all currency is 
		//accurately constructed w/ BigDecimal.
		setTotal();
		
	}
	
	/**
	 * @return
	 */
	public BigDecimal getTotal()
	{
		return total;
	}
	
	public int getNrNickels() {
		return nrNickels;
	}

	public int getNrDimes() {
		return nrDimes;
	}

	public int getNrQrters() {
		return nrQrters;
	}

	public void addNrNickels(int nrNickels) {
		this.nrNickels += nrNickels;
	}

	public void addNrDimes(int nrDimes) {
		this.nrDimes += nrDimes;
	}

	public void addNrQrters(int nrQrters) {
		this.nrQrters += nrQrters;
	}

	public void addTotal(BigDecimal toTotal) {
		total = total.add(toTotal);
	}

	//helper methods
	private void setTotal()
	{
		total = new BigDecimal((nrNickels*0.05) +
				(nrDimes*0.10) +
				(nrQrters*0.25));
		total = total.setScale(2,BigDecimal.ROUND_HALF_EVEN);
	}
	
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String str =	"Nickel(s): " + nrNickels + 
						"\nDime(s): " + nrDimes + 
						"\nQuarter(s): " + nrQrters + 
						"\nTotal: " + total;
		return str;
		
	}
	
	public static void main (String [] args)
	{
		//Testing setters and adders
		Money mnyTest = new Money(0, 0, 0);
		mnyTest.addNrDimes(5);
		mnyTest.addNrNickels(6);
		mnyTest.addNrQrters(7);
		mnyTest.setTotal();
		System.out.println("Money test 1: " + mnyTest);
		mnyTest.addTotal(mnyTest.getTotal());
		System.out.println("Money test 2: " + mnyTest);
		
		
		//Testing Getters
		System.out.println( "Dimes: " + mnyTest.getNrDimes() +
							"\nNickels: " + mnyTest.getNrNickels() + 
							"\nQuarters: " + mnyTest.getNrQrters() + 
							"\nTotal: " + mnyTest.getTotal());
		//Testing extremes and Big_Decimal
		mnyTest.addNrDimes(1000);
		mnyTest.addNrNickels(2000);
		mnyTest.addNrQrters(9999);
		mnyTest.setTotal();
		mnyTest.addTotal(mnyTest.getTotal());
		System.out.println("Money test 3: " + mnyTest);
		
		//Testing getters with extremes
		System.out.println( "Dimes: " + mnyTest.getNrDimes() +
							"\nNickels: " + mnyTest.getNrNickels() + 
							"\nQuarters: " + mnyTest.getNrQrters() + 
							"\nTotal: $" + mnyTest.getTotal());
		
		
		System.out.println("Hey There! We're Done Testing Money!");
	}
}
