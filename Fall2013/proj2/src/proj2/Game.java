package proj2;



public class Game {
	String p1Name;
	String p2Name;
	long rngSeed;
	int gameCount = 0;
	CardPile p1Pile = new CardPile();
	CardPile p2Pile = new CardPile();
	Player player1; 
	Player player2;
	
	public Game(String p1Name, String p2Name, long rngSeed) 
	{
		this.p1Name = p1Name;
		this.p2Name = p2Name;
		this.rngSeed = rngSeed;
		Deck deck = new Deck();
		deck.shuffle(rngSeed);
		splitDeck(deck);
		

	}

	
	
		/**
		 * A method that compares the rank of two cards and returns a boolean 
		 * Precondition: otherCard must not be null
		 * Postcondition: Boolean is returned showing whether or not card ranks match
		 * 
		 * @return: boolean - boolean showing whether two card's ranks match
		 * @param: NONE
		 */
	public int compareCards(Card p1Card, Card p2Card)
	{
		int points1 = 1;
		int points2 = 1;
		
		for (Rank r: Rank.values()) 
		{
			if(r.equals(p1Card.getRank()))
			{
				points1 = 1;
			} 
			else
			{
				points1++;
			}
		}
		
		for (Rank r: Rank.values()) 
		{
			if(r.equals(p2Card.getRank()))
			{
				points2 = 1;
			} 
			else
			{
				points2++;
			}
		}
		
		if(points1>points2)
		{
			System.out.println("Player 1 wins!");
			player1.addScore(0, 1);
			return 1;
		}
		if(points2>points1)
		{
			System.out.println("Player 2 wins!");
			player2.addScore(0, 1);
			return 2;
		}
		else
		{
			System.out.println("WAR!");
			
			return 3;
		}
	}
	
	public void splitDeck(Deck deck)
	{
		for(int i = deck.deckSize()-1 ; i > 0; i--)
		{
			System.out.print(i);
			p1Pile.setPile(deck.getCard(i));
			i--;
			p2Pile.setPile(deck.getCard(i));
		}

	}

	public boolean gameComplete() {
		int t = gameCount;
		if(t < 13)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean nextTurn() 
	{
		
		player1 = new Player(p1Name, p1Pile);
		player2 = new Player(p2Name, p2Pile);
		System.out.println(player1.getaName() + " shows "
				+ p1Pile.nextCard().getRank());
		System.out.println(player2.getaName() + " shows "
				+ p2Pile.nextCard().getRank());
		
		
		compareCards(p1Pile.nextCard(), p2Pile.nextCard());
		
		
		gameCount++;
		
		return false;
	}

	public String gameResult() {
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		
		String end;
		if(player1.scoreTotal() > player2.scoreTotal())
		{
			return end = "Winner: " + player1.getaName();
		}
		else
		{
			return end = "Winner: " + player2.getaName();
		}
		
	}


}