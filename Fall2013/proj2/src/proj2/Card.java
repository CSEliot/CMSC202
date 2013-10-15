package proj2;


public class Card {
	
	/**
	 * The specific Rank of the card
	 */
	private Rank rank;
	/**
	 * The specific Suit of the card
	 */
	private Suit suit;

	/**
	 * A constructor that Constructs a new Card from a specified Rank and Suit
	 * Precondition: NONE
	 * Postcondition: The Card's rank and suit are set.
	 * 
	 * @return: NONE
	 * @param: rank - Rank of the card
	 * @param: suit - Suit of the card
	 */
	public Card(Rank rank, Suit suit){
		if(rank != null && suit != null){
			this.rank = rank;
			this.suit = suit;	
		} else{
			throw new IllegalArgumentException("rank and suit must not be null");
		}
	}
	
	/**
	 * A Copy constructor that Constructs a new Card from an existing Card.
	 * Precondition: otherCard must not be null
	 * Postcondition: The new Card's rank and suit are set.
	 * 
	 * @return: NONE
	 * @param: otherCard
	 */
	public Card(Card otherCard){
		// Only set rank and suit of otherCard is not null
		if(otherCard != null){
			rank = otherCard.getRank();
			suit = otherCard.getSuit();
		} else{
			throw new IllegalArgumentException("otherCard cannot be null");
		}
	}
	
	/**
	 * Accessor for a Card's suit.
	 * Precondition: NONE
	 * Postcondition: Suit of the card is returned.
	 * 
	 * @return: suit - suit of the card
	 * @param: NONE
	 */
	public Suit getSuit(){
		return suit;
	}

	/**
	 * Accessor for a Card's rank.
	 * Precondition: NONE
	 * Postcondition: Rank of the card is returned.
	 * 
	 * @return: rank - Rank of the card
	 * @param: NONE
	 */
	public Rank getRank()
	{
		return rank;
	}
	
	public char getRankSymbol()
	{
		return rank.getSymbol();
	}
	
	
	
	/**
	 * Generates the Card's State string
	 * Precondition: NONE
	 * Postcondition: Card's state string is returned
	 * 
	 * @return: string - string containing a Card's state
	 * @param: NONE
	 */
	public String toString()
	{
    	String string = "";
    	string += "Rank: " + rank.getName() + "\n"; 
    	string += "Suit: " + suit.getName() + "\n";
    	return string;
	}
    	
}