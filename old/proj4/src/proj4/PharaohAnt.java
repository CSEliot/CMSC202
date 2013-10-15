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
public class PharaohAnt extends Ant {

	protected PharaohAnt() 
	{
		super(10, 15, "Pharaoh Ant");
	}

	@Override
	public void attack(Game g) 
	{
		Zombie z = g.getHorde().elementAt(0);
		if (z instanceof Gigantic)
		{
			z.takeDamage(30);
		}
		else
		{	
			z.takeDamage(10);
		}
	}

	@Override
	public void newLife() 
	{
		this.life = 10;
	}

}
