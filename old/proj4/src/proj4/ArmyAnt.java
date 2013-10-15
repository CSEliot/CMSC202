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
public class ArmyAnt extends Ant {

	protected ArmyAnt() 
	{
		super(30, 35, "Army Ant");
	}

	@Override
	public void attack(Game g) 
	{
		int i;
		Zombie z = g.getHorde().elementAt(0);
		//the totalRecruited integer is added by 1 every time at recruitAnt.
		i = g.getArmyAnts();
		z.takeDamage(10 + (5*i));
	}

	@Override
	public void newLife() 
	{
		this.life = 30;
	}

}
