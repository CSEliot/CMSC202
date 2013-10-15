package proj1;

	/**
	 * Project1.java 
	 * @version 10/3/2012
	 * @author Eliot Carney-Seim <eliot2@umbc.edu>
	 * @Lab CMSC 202 - Spring 2012
	 * @section 5
	 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
	 */

import java.util.*;

   public class Project1
   {
	   static Scanner User_Input = new Scanner(System.in);
	   static boolean Locked;
	   	
	   	/**
		 * Helper method for CashRegister's addMoney class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pAddMoney(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like to add to?");
	   			choiceRegister = User_Input.nextInt();
	   			
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		switch(choiceRegister)
	   		{
	   		case 1:
	   			
	   			Locked = Register_One.toString().contains("Locked: true");
	   			
	   			if(Locked == true)
	   			{
	   				System.err.println("Please first unlock Register One");
	   				return;
	   			}
	   			break;
	   			
	   		case 2:
	   			Locked = Register_Two.toString().contains("Locked: true");
	   			if(Locked == true)
	   			{
	   				System.err.println("Please first unlock Register Two");
	   				return;
	   			}
	   			break;
	   		default:
	   			break;
	   		}
	   		
	   		System.out.println( "Enter the following quantity of bills to add, starting with \nOnes: ");
	   			int Ones = User_Input.nextInt();
	   			System.out.println("Fives: ");
	   			int Fives = User_Input.nextInt();
	   			System.out.println("Tens: ");
	   			int Tens = User_Input.nextInt();
	   			System.out.println("Twenties: ");
	   			int Twenties = User_Input.nextInt();
	   		
	   		if(Ones < 0 || Fives < 0 || Tens < 0 || Twenties < 0)
	   		{
	   			System.err.println("Please enter a positive integer.");
	   			return;
	   		}
	   		
	   		switch (choiceRegister)
	   		{
	   			case 1:
	   				Register_One.addMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			case 2:
	   				Register_Two.addMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			default:
	   				System.err.println("");
	   				break;
	   		}
	   		return;
	   		
	   	}
	    /**
		 * Helper method for CashRegister's openShop class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pOpenShop(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		System.out.println("Welcome to RegisterU!");
	   		System.out.println("Now unlocking your registers. . .");
	   		Register_One.openShop(0, 0, 0, 0, false);
	   		Register_Two.openShop(0, 0, 0, 0, false);
	   		
	   		System.out.println("Beginning with Register [1], how many of each bill are you opening with?\nOnes: ");
	   		int Ones = User_Input.nextInt();
	   		System.out.println("Fives: ");
	   		int Fives = User_Input.nextInt();
	   		System.out.println("Tens: ");
	   		int Tens = User_Input.nextInt();
	   		System.out.println("Twenties: ");
	   		int Twenties = User_Input.nextInt();
	   		
	   		Register_One.openShop(Twenties, Tens, Fives, Ones, false);
	   		
	   		System.out.println("Register [2], how many of each bill are you opening with?\nOnes: ");
	   		Ones = User_Input.nextInt();
	   		System.out.println("Fives: ");
	   		Fives = User_Input.nextInt();
	   		System.out.println("Tens: ");
	   		Tens = User_Input.nextInt();
	   		System.out.println("Twenties: ");
	   		Twenties = User_Input.nextInt();
	   		
	   		if(Ones < 0 || Fives < 0 || Tens < 0 || Twenties < 0)
	   		{
	   			System.err.println("Please enter a positive integer.");
	   			return;
	   		}
	   		
	   		Register_Two.openShop(Twenties, Tens, Fives, Ones, false);
	   	}	
	    /**
		 * Helper method for CashRegister's removeMoney class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pRemoveMoney(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   	
   			
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like to remove from?");
	   			choiceRegister = User_Input.nextInt();
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		switch(choiceRegister)
	   		{
	   		case 1:
	   			Locked = Register_One.toString().contains("Locked: true");
	   			if(Locked == true)
	   			{
	   				System.err.println("Please first unlock Register One");
	   				return;
	   			}
	   			break;
	   		case 2:
	   			Locked = Register_Two.toString().contains("Locked: true");
	   			if(Locked == true)
	   			{
	   				System.err.println("Please first unlock Register Two");
	   				return;
	   			}
	   			break;
	   		default:
	   			break;
	   		}
	   		
	   		
	   		System.out.println( "Enter the following quantity of bills to remove, starting with \nOnes: ");
	   		int Ones = User_Input.nextInt();
	   		System.out.println("Fives: ");
	   		int Fives = User_Input.nextInt();
	   		System.out.println("Tens: ");
	   		int Tens = User_Input.nextInt();
	   		System.out.println("Twenties: ");
	   		int Twenties = User_Input.nextInt();
	   		
	   		if(Ones < 0 || Fives < 0 || Tens < 0 || Twenties < 0)
	   		{
	   			System.err.println("Please enter a positive integer.");
	   			return;
	   		}
	   		
	   		switch (choiceRegister)
	   		{
	   			case 1:
	   				Register_One.removeMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			case 2:
	   				Register_Two.removeMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			default:
	   				System.err.println("");
	   				break;
	   		}
	   		return;
	   	}
	    /**
		 * Helper method for CashRegister's displayState class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pDisplayState(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like display?");
	   			choiceRegister = User_Input.nextInt();
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		switch(choiceRegister)
	   		{
	   			case 1:
	   				System.out.println("Displaying current state of register 1. . .");
	   				String str1 = " \n" + Register_One.toString();
	   				System.out.println("" + str1);
	   				break;
	   			case 2:
	   				System.out.println("Displaying current state of register 2. . .");
	   				String str2 = " \n" + Register_Two.toString();
	   				System.out.println("" + str2);
	   				break;
	   		}
	   	}
	    /**
		 * Helper method for CashRegister's transferMoney class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pTransferMoney(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		Locked = Register_One.toString().contains("Locked: true");
   			if(Locked == true)
   			{
   				System.err.println("Please first unlock Register One");
   				return;
   			}	
   			Locked = Register_Two.toString().contains("Locked: true");
   			if(Locked == true)
   			{
   				System.err.println("Please first unlock Register Two");
   				return;
   			}
   			
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like to transfer FROM?");
	   			choiceRegister = User_Input.nextInt();
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		System.out.println( "Enter the following quantity of bills to transfer, starting with \nOnes: ");
	   		int Ones = User_Input.nextInt();
	   		System.out.println("Fives: ");
	   		int Fives = User_Input.nextInt();
	   		System.out.println("Tens: ");
	   		int Tens = User_Input.nextInt();
	   		System.out.println("Twenties: ");
	   		int Twenties = User_Input.nextInt();

	   		switch (choiceRegister)
	   		{
	   			case 1:
	   				Register_One.removeMoney(Twenties, Tens, Fives, Ones);
	   				Register_Two.addMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			case 2:
	   				Register_Two.removeMoney(Twenties, Tens, Fives, Ones);
	   				Register_One.addMoney(Twenties, Tens, Fives, Ones);
	   				break;
	   			default:
	   				System.err.println("");
	   				break;
	   		}
	   		return;
	
	   		
	   		
	   	}
	    /**
		 * Helper method for CashRegister's registerUnlock class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pRegisterUnlock(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like to Unlock?");
	   			choiceRegister = User_Input.nextInt();
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		switch(choiceRegister)
	   		{
	   			case 1:
	   				Register_One.registerUnlock();
	   				System.out.println("Register 1 is now unlocked...");
	   				break;
	   			case 2:
	   				Register_Two.registerUnlock();
	   				System.out.println("Register 2 is now unlocked...");
	   				break;
	   			default:
	   				break;
	   		}
	   	}
	    /**
		 * Helper method for CashRegister's registerLock class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pRegisterLock(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		int choiceRegister = 0;
	   		do
	   		{
	   			
	   			System.out.println("Which Register would you like to lock?");
	   			choiceRegister = User_Input.nextInt();
	   			if (choiceRegister != 2 && choiceRegister != 1)
	   			{
	   			System.err.println("Please choose a proper Register");
	   			}
	   			
	   			
	   		}while(choiceRegister != 2 && choiceRegister != 1);
	   		
	   		switch(choiceRegister)
	   		{
	   			case 1:
	   				Register_One.registerLock();
	   				System.out.println("Register 1 is now locked...");
	   				break;
	   			case 2:
	   				Register_Two.registerLock();
	   				System.out.println("Register 2 is now locked...");
	   				break;
	   			default:
	   				break;
	   		}
	   	}
	    /**
		 * Helper method for CashRegister's closeShop class.
		 * Precondition: None
		 * Postcondition: None
		 * @param: Register_One, Register_Two
		 * @return: No return value
		 */
	   	public static void pCloseShop(CashRegister Register_One, CashRegister Register_Two)
	   	{
	   		System.out.println("Removing cash from Register 1...");
	   		int totalMade1 = Register_One.closeShop();
	   		System.out.println("You made: " + totalMade1 + " today from Register 1.");
	   		System.out.println("Locking Register 1...");
	   		Register_One.registerLock();
	   		System.out.println("Final status of Register 1:");
	   		String str = " \n" + Register_One.toString();
	   		System.out.println(str);
	   		
	   		System.out.println("Removing cash from Register 2...");
	   		int totalMade2 = Register_Two.closeShop();
	   		System.out.println("You made: " + totalMade2 + " today from Register 2.");
	   		System.out.println("Locking Register 2...");
	   		Register_Two.registerLock();
	   		System.out.println("Final status of Register 2:");
	   		String str2 = " \n" + Register_Two.toString();
	   		System.out.println(str2);
	   		
	   		int combinedTotal = totalMade1 + totalMade2;
	   		System.out.println("You made a combined total of: " + combinedTotal);
	   		
	   		
	   		
	   	}
	    /**
		 * prints the Menu Screen text-based UI when called.
		 * Precondition: None
		 * Postcondition: None
		 * @param:
		 * @return: No return value
		 */
	   	private static void Menu_Screen()
    	{
    		System.out.println("A - Add money\nR - Remove money\nT - Transfer money\nL - Lock register");
    		System.out.println("U - Unlock register\nS - Display register state\nC - Close the store and quit");
    	}
	    /**
		 * Package driver.
		 * Precondition: None
		 * Postcondition: None
		 * @param: radius: args Command-line arguments
		 * @return: No return value
		 */
    	public static void main (String[]args)
   		{
    		
    		
    		CashRegister Register_One = new CashRegister();
        	CashRegister Register_Two = new CashRegister();
        	
        	pOpenShop(Register_One, Register_Two);
        	
   			char choiceChar;
   			do
   			{
   				Menu_Screen();
  
   				
   				String choiceString = User_Input.next();
   				choiceString = choiceString.toUpperCase();
   	    		choiceChar = choiceString.charAt(0);

   				switch (choiceChar)
   				{
    				case 'A':
    					pAddMoney(Register_One, Register_Two);
    					break;
    				case 'R':
    					pRemoveMoney(Register_One, Register_Two);
   						break;
    				case 'T':
    					pTransferMoney(Register_One, Register_Two);
    					break;
    				case 'L':
    					pRegisterLock(Register_One, Register_Two);
    					break;
    				case 'U': 
    					pRegisterUnlock(Register_One, Register_Two);
    					break;
    				case 'S':
    					pDisplayState(Register_One, Register_Two);
    					break;
    				case 'C':
    					System.out.println ( "Now closing the shop..." );
    					pCloseShop(Register_One, Register_Two);
    					break;
    				default:
    					System.err.println ( "Error: Improper Input." );
    					break;
   				}
   			}while(choiceChar != 'C');
   		}	
   }
   		
   
	


