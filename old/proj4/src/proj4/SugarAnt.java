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
public class SugarAnt extends Ant {

	protected SugarAnt()
	{
		super(20, 20, "Sugar Ant");
	}

	@Override
	public void attack(Game g) 
	{
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(20);
		if(z.getLife() <= 0)
		{
			//add 5 food to game's food if zombie died.
			g.setFood(g.getFood()+5);
		}
	}

	@Override
	public void newLife() 
	{
		this.life = 20;
	}

}
