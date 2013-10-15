package proj2;

public class Player {
	int cardScore;
	int warScore;
	CardPile pile;
	String name;
	
	public Player(String name, CardPile pile)
	{
		this.name = name;
		this.pile = pile;
		warScore = 0;
		cardScore = 0;
	}

	public void addScore(int addWar, int addCard)
	{
		warScore += addWar;
		cardScore += addCard;
	}
	
	public Card playCard()
	{
		return pile.nextCard();
	}
	
	public String getaName()
	{
		return name;
	}
	
	public int scoreTotal()
	{
		return cardScore;
	}
	public String toString()
	{
		String str = "\n";
		str += name + " won " + cardScore + " cards and " 
		+ warScore + "war(s) ";

		return str;
	}
}
