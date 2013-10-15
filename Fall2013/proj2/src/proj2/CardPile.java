package proj2;


public class CardPile {

	private Card [] deckHalf; 
	private int nextNull;
	private int nextCard;
	
	public CardPile()
	{
		deckHalf = new Card[26];
		nextNull = 0;
		nextCard = 26;
	}
	
	public String toString()
	{
		String str = "" ;
		for(int i=0; i<deckHalf.length; i++)
		{
			str += "Card " + i + " in Deck:\n" + deckHalf[i].toString() + "\n";
		}
		
		return str;
	}
	
	public void setPile(Card card)
	{
		this.deckHalf[nextNull] = card;
		System.out.println("Cards Position: " + nextNull + deckHalf[nextNull].toString());
		nextNull++;
	}
	public static void main()
	{
		CardPile pile = new CardPile();
		pile.toString();
	}
	
	public Card getCard(int index)
	{
		if(index < deckHalf.length && index >= 0)
		{
			return deckHalf[index];
		} 
		else 
		{
			System.out.println("Index: " + index);
			throw new IllegalArgumentException("index be between 0 and " +
					"deck length " + (deckHalf.length - 1));
		}
	}
	
	public Card nextCard()
	{
		nextCard--;
		return deckHalf[nextCard];
	}
}
	