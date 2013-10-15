package proj1;
/**
 * CashRegister.java
 * @version 10/3/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 */

public class CashRegister 
{

	private int Twenties;
	private int Tens;
	private int Fives;
	private int Ones;
	private boolean isLocked;
	

	public CashRegister() 
	{
		Twenties = 0;
		Tens = 0;
		Fives = 0;
		Ones = 0;
		isLocked = true;
	}

	/**
	 * Opens the shop by unlocking both registers, asking the user to input the number of each
	 * of the four bill denominations to put into each register (each register gets the same 
	 * number of each bill), and putting the bills into each register.
	 * Precondition: Bill quantity must be greater than 0.
	 * Postcondition: None
	 * @param: Twenties, Tens, Fives, Ones, isLocked
	 * @return: No return value
	 */
	public void openShop(int Twenties, int Tens, int Fives, int Ones, boolean isLocked )
	{
		if(Ones < 0 || Tens < 0 || Twenties < 0 || Fives < 0)
		{
			throw new RuntimeException("Number of bills must remain positive.");
		}
		this.Ones = Ones;
		this.Fives = Fives;
		this.Tens = Tens;
		this.Twenties = Twenties;
		this.isLocked = isLocked;
		
	}
	
	/**
	 * Asks the user which register (1 or 2) to add money to and then the amount to add
	 * (number of ones, fives, tens, and twenties). Adds the bills to the register.
	 * Precondition: None
	 * Postcondition: None
	 * @param: Twenties, Tens, Fives, Ones, 
	 * @return: No return value
	 */
	public void addMoney(int Twenties, int Tens, int Fives, int Ones)
	{
		this.Twenties = this.Twenties + Twenties;
		this.Tens = this.Tens + Tens;
		this.Fives = this.Fives + Fives;
		this.Ones = this.Ones + Ones;
		
	}
	
	/**
	 * Asks the user which register to remove money from and then the amount to remove 
	 * (number of ones, fives, tens, and twenties). Removes the bills from the register. 
	 * Precondition: None
	 * Postcondition: Amount being removed must not be greater than original amount.
	 * @param: Twenties, Tens, Fives, Ones, 
	 * @return: No return value
	 */
	public void removeMoney(int Twenties, int Tens, int Fives, int Ones)
	{
		if(Twenties > this.Twenties || Tens > this.Tens || Fives > this.Fives || Ones > this.Ones)
		{
			throw new RuntimeException("The amount withdrawn must be less than or equal to the amount currently in possession.");
		}
		
		this.Twenties = this.Twenties - Twenties;
		this.Tens = this.Tens - Tens;
		this.Fives = this.Fives - Fives;
		this.Ones = this.Ones - Ones;
	}
	
	/**
	 * Returns the status of X register to the user.  
	 * Precondition: None
	 * Postcondition: None
	 * @param: None 
	 * @return: String str.
	 */
	public String toString()
	{
		int total = (Twenties*20) + (Tens*10) + (Fives*5) + (Ones*1);
		String str = "Locked: " + isLocked + "\nOnes: " + Ones + "\nFives:" + Fives + "\nTens: " + Tens + "\nTwenties: " + Twenties + "\nTotal: " + total;
		return str;
	}
	
	/**
	 * Locks X register. 
	 * Precondition: Register cannot be already locked.
	 * Postcondition: None
	 * @param: None
	 * @return: No return value
	 */
	public void registerLock()
	{
		if(isLocked == true)
		{
			throw new RuntimeException("Register is already locked");
		}
		this.isLocked = true;
	}
	
	/**
	 * Unlocks X register. 
	 * Precondition: Register cannot be already unlocked.
	 * Postcondition: None
	 * @param: Nonce
	 * @return: No return value
	 */
	public void registerUnlock()
	{
		if(isLocked == false)
		{
			throw new RuntimeException("Register is already unlocked");
		}
		this.isLocked = false;
	}
	
	/**
	 * Closes your store by removing the money from both registers, 
	 * locking both registers (called seperately in main), displaying the 
	 * state of both registers, and exiting the program. 
	 * Precondition: None
	 * Postcondition: None
	 * @param: None
	 * @return: No return value
	 */
	public int closeShop()
	{
		int totalMade = (Twenties*20) + (Tens*10) + (Fives*5) + (Ones*1);
		this.Ones = 0;
		this.Fives = 0;
		this.Tens = 0;
		this.Twenties = 0;
		return totalMade;
		
	}
	
}
