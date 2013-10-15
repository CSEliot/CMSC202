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
public class WeaverAnt extends Ant {

	protected WeaverAnt()
	{
		super(10, 20, "Weaver Ant");
	}

	@Override
	public void attack(Game g) 
	{
		//if there aren't more than 1 zombie in the horde,
		//weaver ant's attack does nothing.
		if(g.getHorde().size() > 1)
		{
			Zombie z = g.getHorde().elementAt(1);
			z.takeDamage(15);
		}
	}

	@Override
	public void newLife() 
	{
		this.life = 10;
	}

}
