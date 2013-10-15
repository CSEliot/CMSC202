package proj4;
/**
 * BulletAnt.java
 * @version 11/26/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * 
 * Class Invariants: none
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings("unused")
public class Game implements GameInterface 
{
	/******************** README ********************/
	//In regards to commented-out text, if it's using 3 forward-slashes (///) 
	//it means that those are used for testing, otherwise the text of for
	//clarifications.
	
    /******************** instance variables ********************/
	Ant ant;
	Object test = (Object) ant;
	Vector <Ant> colony = new Vector<Ant>();
	Vector <Zombie> horde = new Vector<Zombie>();
	Integer food = 100;
	Boolean gameOver = false;
	int round = 1;
	//every time recruitAnt is run, if it can recruit, this int goes up by 1.
	int armyAnts = 0;
	Boolean victory = false;
	/*************** methods declared in GameInterface ****************/

	
	
    /**
     * Execute a fight between the first ant in the colony and first
     * zombie in the horde.
     */
    public void nextFight() 
    {
		Ant a = colony.elementAt(0);
		a.attack(this);
	
		Zombie z = horde.elementAt(0);
///		System.out.println(horde);
		if ((a instanceof LeafcutterAnt) && (z.getLife() <= 0)) {
		    // leafcutters have first strike, so opposing zombie gets no attack
		}
		else {
		    z.attack(this);
		}
	
		// reap all things dead
		boolean keepReaping = true;
		while (keepReaping) {
		    keepReaping = false;
		    for (int i = 0; i < colony.size(); ) {
			a = colony.elementAt(i);
			if (a.getLife	() > 0) {
			    i++;
			}
			else {
			    colony.remove(i);
			    if (a instanceof CitronellaAnt) {
				for (Ant a2 : colony) {
				    a2.takeDamage(2);
				}
				for (Zombie z2: horde) {
				    z2.takeDamage(2);
				}
			    }
			    keepReaping = true;
			}
		    }
		    
		    for (int i = 0; i < horde.size(); ) {
			z = horde.elementAt(i);
			if (z.getLife() > 0) {
			    i++;
			}
			else {
			    horde.remove(i);
			    food += z.getReward();
			}
		    }
		}
		if (colony.size() == 0 && horde.size() > 0) 
		{
		    gameOver = true;
		}
    }
    
    /**
     * Return the current round for the game.
     * @return 1 through 5, inclusive
     */
	public int getRoundNumber() 
	{
		return round;
	}

	/**
     * Return the amount of food the player's colony currently has.
     * @return food remaining
     */
	public int getFood() 
	{
		return food;
	}

	/**
     * Return a string that lists all of the ants in the player's colony.
     * The list is in order, and has newlines separating ants.
     * 
     * In the try-catch, if the colony is empty, it will not try to 
     * add elements from the colony to the string, because there are none.
     * @return Multiline description of colony.
     */
	public String getColonyDesc() 
	{
		int i=0;
		String antList = "";
		do
		{
///			System.out.println(i);
			try
			{
				if(!colony.isEmpty())
				{
					antList += colony.elementAt(i).getDesc() 
							+ " - remaining life: " + colony.elementAt(i).getLife() 
							+ "\n";
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Tried to add too many Ants, causing: " +e);
			}
			i++;
		}
		while(i<=colony.size()-1);
///		System.out.println("This is the antList: " + antList);
		return antList;
	}

	/**
     * Callback invoked when the player attempts to recruit an ant.
     * If true, cost will be subtracted from food,totalRecruited goes up 1, 
     * and the ant is added to colony.
     * @param antType Type of ant to recruit
     * @param antX A char used as a temp. place-holder for ant names.		   
     * @return true if the player may recruit the ant, false if not.
     */
	@Override
	public boolean recruitAnt(String antType) 
	{
		//if the ant name is equal to given anttype, creates
		// a char for the given name.
		char antX = getSymbol(antType);
///		System.out.println("This is the symbol: " + antX);
		//Condition checking.
		if (antX == 'n'){return false;}
		Ant a = null;
		switch (antX) 
		{
	    	case 'A': a = new ArmyAnt(); break;
	    	case 'B': a = new BulletAnt(); break;
	    	case 'C': a = new CarpenterAnt(); break;
	    	case 'I': a = new CitronellaAnt(); break;
	    	case 'F': a = new FireAnt(); break;
	    	case 'L': a = new LeafcutterAnt(); break;
	    	case 'P': a = new PharaohAnt(); break;
	    	case 'S': a = new SugarAnt(); break;
	    	case 'T': a = new ThiefAnt(); break;
	    	case 'W': a = new WeaverAnt(); break;
	    	default: System.err.println("Improper case given @recruitAnt," +
	    								"default launched.s");
		}
///		System.out.println("This is the cost: " + a.getCost());
		//check if enough food is available
		if(a.getCost() > food){return false;}
		else
		{   //takes away food, adds to army Ant's total
			//and adds to colony, of course.
			food -= a.getCost();
			if(a.getDesc().contentEquals("Army Ant"))
			{
				armyAnts++;
			}
 			colony.add(a);
			return true;
		}
	}

	 /**
     * Read and parse the Zombie String within a zombie file.
     * @param filename File containing Zombie String
     */
	public void readHordeFile(String hordeList) 
	{	

		String zombieString = null;
		java.io.FileReader file;
		try {
			file = new java.io.FileReader(hordeList);
			java.io.BufferedReader buf = new java.io.BufferedReader(file);
			zombieString = buf.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
///		System.out.println(zombieString);
		int i = 0;
///		String test = filename;
///		System.out.println(hordeList);
		do
		{
///			Character testIn = test.charAt(i);
			if(Character.isLetter(zombieString.charAt(i)))
			{
				Zombie addZombie = Zombie.makeZombie(zombieString.charAt(i));
				horde.add(addZombie);
				///System.out.println("LETTER!");
			}
			else
			{
				//if not a letter. . .
				//this will recreate zombie for number given
				int loop = Character.getNumericValue(zombieString.charAt(i));
				///System.out.println("loop: " + loop);
				do
				{
					///System.out.println("Num: " + loop);
					Zombie addZombie = Zombie.makeZombie(zombieString.charAt(i-1));
					horde.add(addZombie);
					loop--;
				}
				while(loop >= 1);
				///System.out.println("Number!");
				
			}
			i++;
		}
		while(i<=zombieString.length()-1);
		
		//Code for testing horde.
		/*int totalElements = horde.size();
		for(int index=0; index < totalElements; index++)
		{
		      System.out.println(horde.get(index));
		}*/
		
	}

	/**
     * Return a string that lists all of the zombies in the current
     * invasion The list is in order, and has newlines separating
     * zombies.
     * @return Multiline description of horde (name and life).
     */
	public String getHordeDesc() 
	{		
		int i=0;
		String zombieList = "";
		do
		{
///			System.out.println(i);
			try
			{
				
///				System.out.println("Adding to the list from Horde: " + i 
///						+ horde.elementAt(i).getDesc() + "\n" + "Size: " 
///						+ horde.size());
				if(!horde.isEmpty())
				{
					zombieList += horde.elementAt(i).getDesc()
					           + " - remaining life: " 
					           + horde.elementAt(i).getLife() 
					           + "\n";
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Error with adding to zombieList: " + e);
			}
			i++;
		}
		while(i<=horde.size()-1);
	return zombieList;
	}

	 /**
     * Determine if the invasion is over. If the invasion is over, all
     * remaining ants' health reset to full life.
     * @return true if there are no ants or no zombies remaining or both..
     */
	@Override
	public boolean isInvasionOver() 
	{
		if(horde.size() == 0)
		{
			//if horde is defeated, give ants new life.
			for(int i = 0; i == colony.size()-1; i++ )
			{	
				colony.elementAt(i).newLife();
			}
			//moving on to the next round.
			round++;
			//if the next round that is about to begin is 6, meaning 5 was beat
			//roundControl will take care of seeing the game end.
			roundControl();
			return true;
		}
		else if(colony.size() == 0 && horde.size() == 0)
		{	
			//if both sides end with 0 elements, at same time.
			return true;
		}
		else if(colony.size() == 0 && horde.size() > 0)
		{
			//if player has no elements, yet horde does.
			gameOver = true;
			return true;
		}
		else
		{
			//the fight goes on!
			return false;
		}
	}


	 /**
     * Determine if the game is over or not.
     * @return true if game is over or not.
     */
	public boolean isGameOver() 
	{
		return gameOver;
	}

	
	
	public String getEndingMessage() 
	{
		if(victory == null)
		{
			System.err.println("Victory was set to null by user.");
			System.exit(0);
			return null;
		}
		else if(victory)
		{
			String winString = "Congratulations! don't get your hopes up >:(";
			winString += "\nHere's your score or whatever: " + food;
			return winString;
		}
		else
		{
			String failString = "Too bad, maybe you'll win next time!\n" +
								"but probably not, it's statistically proven." +
								"\nSeriously, it's been shown that failure " +
								"only brings increasing returns, no hope.";
			return failString;
		}
	}
	
	 /**
     * Return an array of all types of ants that may be recruited.
     * This array will be used to construct the recruiting buttons
     * during Recruit phase.
     * @param allReadyAnts The string array holding all ants that can be bought
     * @return returns the string of varying sizes depending on food.
     */

	public String[] getAntTypes() 
	{
		int i = 0;
		if(food <= 14 && food >= 10)
		{
			String [] allReadyAnts = new String [2];
			allReadyAnts[0] = "Bullet Ant";
			allReadyAnts[1] = "Carpenter Ant";
			return allReadyAnts;
		}
		else if(food <= 19 && food >= 10)
		{
			String [] allReadyAnts = new String [5];
			allReadyAnts[0] = "Bullet Ant";
			allReadyAnts[1] = "Carpenter Ant";
			allReadyAnts[2] = "Fire Ant";
			allReadyAnts[3] = "Pharaoh Ant";
			allReadyAnts[4] = "Thief Ant";
			return allReadyAnts;
		}
		else if(food <= 24 && food >= 10)
		{
			String [] allReadyAnts = new String [8];
			allReadyAnts[0] = "Bullet Ant";
			allReadyAnts[1] = "Carpenter Ant";
			allReadyAnts[2] = "Fire Ant";
			allReadyAnts[3] = "Pharaoh Ant";
			allReadyAnts[4] = "Thief Ant";
			allReadyAnts[5] = "Leafcutter Ant";
			allReadyAnts[6] = "Sugar Ant";
			allReadyAnts[7] = "Weaver Ant";
			return allReadyAnts;
		}
		else if(food <= 34 && food >= 10)
		{
			String [] allReadyAnts = new String [9];
			allReadyAnts[0] = "Bullet Ant";
			allReadyAnts[1] = "Carpenter Ant";
			allReadyAnts[2] = "Fire Ant";
			allReadyAnts[3] = "Pharaoh Ant";
			allReadyAnts[4] = "Thief Ant";
			allReadyAnts[5] = "Leafcutter Ant";
			allReadyAnts[6] = "Sugar Ant";
			allReadyAnts[7] = "Weaver Ant";
			allReadyAnts[8] = "Citronella Ant";
			return allReadyAnts;
		}
		else if(food >= 35)
		{
			String [] allReadyAnts = new String [10];
			allReadyAnts[0] = "Bullet Ant";
			allReadyAnts[1] = "Carpenter Ant";
			allReadyAnts[2] = "Fire Ant";
			allReadyAnts[3] = "Pharaoh Ant";
			allReadyAnts[4] = "Thief Ant";
			allReadyAnts[5] = "Leafcutter Ant";
			allReadyAnts[6] = "Sugar Ant";
			allReadyAnts[7] = "Weaver Ant";
			allReadyAnts[8] = "Citronella Ant";
			allReadyAnts[9] = "Army Ant";
			return allReadyAnts;
		}
		
		return null; 
	}

	 /**
     * Return the cost to recruit a particular ant.
     * @param antType Type of ant to recruit.
     * @param antX temporary placeholder for cycling through ants.
     * @return Food cost to recruit.
     */
	public int getAntCost(String antType) 
	{
		Ant a;
		char antX = getSymbol(antType);
		switch (antX) 
		{
	    	case 'A': return new ArmyAnt().getCost();
	    	case 'B': return new BulletAnt().getCost();
	    	case 'C': return new CarpenterAnt().getCost();
	    	case 'I': return new CitronellaAnt().getCost();
	    	case 'F': return new FireAnt().getCost();
	    	case 'L': return new LeafcutterAnt().getCost();
	    	case 'P': return new PharaohAnt().getCost();
	    	case 'S': return new SugarAnt().getCost();
	    	case 'T': return new ThiefAnt().getCost();
	    	case 'W': return new WeaverAnt().getCost();
	    	default: System.err.println("Improper case given @getAntCost, " +
	    								"default launched.");
		}
		return 0;
	}
	

    /******************** other methods ********************/

	 /**
     * A helper method for turning ant names into easy-use chars.
     * @param antType Type of ant to recruit.
     * @param antX temporary placeholder for cycling through ants.
     * @return antX containing a letter corresponding to an ant name.
     * preconditions: none
     * postconditions: antX is = a supported character.
     */
	private char getSymbol(String antType)
	{
		char antX;
		if(antType == null)
		{
			System.err.println("No ant name given. ");
			antX = 'n';
		}
		else if(antType.equals("Army Ant")){antX = 'A';}
		else if(antType.equals("Bullet Ant")){antX = 'B';}
		else if(antType.equals("Carpenter Ant")){antX = 'C';}
		else if(antType.equals("Citronella Ant")){antX = 'I';}
		else if(antType.equals("Fire Ant")){antX = 'F';}
		else if(antType.equals("Leafcutter Ant")){antX = 'L';}
		else if(antType.equals("Pharaoh Ant")){antX = 'P';}
		else if(antType.equals("Sugar Ant")){antX = 'S';}
		else if(antType.equals("Thief Ant")){antX = 'T';}
		else if(antType.equals("Weaver Ant")){antX = 'W';}
		else
		{
			System.err.println("Inserted ant name does not exist."); 
			antX = 'n'; 
		}
		return antX;
	}
	
	 /**
     * Returns colony.
     * @param colony
     * @return colony
     */
	public Vector<Ant> getColony() 
	{
		return colony;
	}
	 /**
     * Returns horde.
     * @param horde
     * @return horde
     */
	public Vector<Zombie> getHorde() 
	{

		return horde;
	}
	
	public void removeFood(int i) 
	{
		food = food - i;
		
	}
	 /**
     * checks the round number so it doesn't go past chosen # of rounds.
     * if player makes it past final round, victory = true.
     */
	private void roundControl() 
	{
		if(round > 5)
		{
			gameOver = true;
			//if you've made it past round 5, you've won.
			victory = true;
		}
	}

	public int getArmyAnts()
	{
		return armyAnts;
	}

	public void setFood(Integer food) 
	{
		this.food = food;
	}

	//Unit testing Below vvvvvvvvvvvvvvvvvvvvv
	/*public static void main (String [] args)
	{
		Game testing = new Game();
		testing.readHordeFile("AG3");
	
	
	}*/




}



