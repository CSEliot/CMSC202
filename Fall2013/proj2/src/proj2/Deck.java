package proj2;

import java.util.Random;


/**
 * Deck.java 
 * @version 10/21/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance TA: John Seymour. Suitemate: Puya Maleki, Faisal Mahmood
 
 * Class Invariant
 *	1. Number of cards in the deck will always be 52 ( deck will always be of size 52)
 *	2. Number of card ranks will always be 13 ( ranks array will always be of size 13)
 *	3. Number of card suits will always be 4 ( suits array will always be of size 13)
 *	4. Index integer passed into getCard will always be between 0 and deck length - 1
 */

public class Deck {

	/**
	 * An array containing all possible card ranks
	 */
	 
	private Card[] deck = new Card[52];
	/**
	 * Integer is used as the index number when assigning putting cards in deck array
	 */
	private int cardNumber = 0;
	/**
	 * A randomly generated number used for shuffling the deck
	 */
	private int randomNum;

	/**
	 * A constructor that Constructs a standard deck of 52 cards.
	 * Precondition: NONE
	 * Postcondition: An array is created containing 52 cards in order
	 * 
	 * @return: NONE
	 * @param: NONE
	 */
	public Deck() 
	{
		// suits array and ranks array are filled with all possible ranks and suits
		// Two for loops fill in deck array with 52 unique cards in specific order
		for (Suit s: Suit.values()) 
		{
			for (Rank r: Rank.values()) 
			{

				deck[cardNumber] = new Card(r, s);
				//deck index is incremented
				cardNumber++;
			}
		}
		//deck.toString();
	}
	
	/**
	 * A method that returns a Card at the given index of the Card array. 
	 * Precondition: index must be between 0 and the deck length
	 * Postcondition: Card at given index is returned
	 * 
	 * @return: deck[index] - Card at given index
	 * @param: index - index of the card you are trying to find 
	 */
	public Card getCard(int index)
	{
		if(index < deck.length && index >= 0)
		{
			return deck[index];
		} 
		else 
		{
			System.out.println("Index: " + index);
			throw new IllegalArgumentException("index be between 0 and " +
					"deck length " + (deck.length - 1));
		}
	}
	
	/**
	 * A method that returns the size of the deck 
	 * Precondition: NONE
	 * Postcondition: size of the deck is returned
	 * 
	 * @return: deck.length - length of the deck
	 * @param: NONE
	 */
	
	public int deckSize(){
		return deck.length;
	}
	
	/**
	 * A method that shuffles the deck using an algorithm using a passed in seed 
	 * Precondition: NONE
	 * Postcondition: Card deck is shuffled
	 * 
	 * @return: NONE
	 * @param: gameNum - a gameNum long that is used to generate random numbers
	 */
	
	public void shuffle(long rngSeed){
		// random object is created
		Random rand = new Random(rngSeed);
		int n = deck.length;
		int N = n - 1;
		/* Algorithm is followed, leaving the top of the array as the first
		 * card, being the 3 of Diamonds. 
		 */ 
		for(int i = 0; i < n; i++){
			
			randomNum = rand.nextInt(deck.length - i);
			Card temp = new Card(deck[randomNum]);
			deck[randomNum] = new Card(deck[N]);
			deck[N] = new Card(temp);
			N--;
		}
		
	}
	/**
	 * Generates the Card Deck's State string
	 * Precondition: NONE
	 * Postcondition: Card Deck's state string is returned
	 * 
	 * @return: string - string containing the Deck's state
	 * @param: NONE
	 */
	public String toString()
	{
		String string = "";
    	for(int i = 0; i < deck.length; i++)
    	{
    		string += "Card: " + (i + 1) + "\n"; 
    		string += deck[i].toString() + "\n";
    	}
    	return string;
	}
	
	public static void main(String[] args) {

		// Basic Cases
		System.out.println("BASIC TESTS \n \n");
		
		// Call Constructor 
		Deck deck1 = new Deck();
		
		// Invoke getCard() method
		// testing lower bound
		System.out.println("Card in deck1 at index 0:");
		System.out.println(deck1.getCard(0) + "\n");
		System.out.println("Card in deck1 at index 1:");
		System.out.println(deck1.getCard(1) + "\n");
		// testing upper bound
		System.out.println("Card in deck1 at index 51:");
		System.out.println(deck1.getCard(51) + "\n");
		System.out.println("Card in deck1 at index 50:");
		System.out.println(deck1.getCard(50) + "\n");
		
		// Invoke deckSize() method
		System.out.println("Deck size of deck1:");
		System.out.println(deck1.deckSize() + "\n");
		
		// Invoke toString() method
		System.out.println("Deck deck1 toString:");
		System.out.println(deck1.toString() + "\n");
		
		// Invoke shuffle method and check with toString()
		System.out.println("Deck deck1 toString after being shuffled:");
		deck1.shuffle(123456);
		System.out.println(deck1.toString() + "\n");
		
		//Try getting Cards with getCard() at invalid parameters
		//Less than 0 (negative)
		/*
		deck1.getCard(-100);
		*/
		//Greater than 52 (deck.deckSize())
		/*
		deck1.getCard(100);
		*/
	}
		
}