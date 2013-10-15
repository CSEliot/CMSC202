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

public class FireAnt extends Ant {

	protected FireAnt() {
		super(20, 15, "Fire Ant");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(Game g) {
		Zombie z = g.getHorde().elementAt(0);
		//testing for interface
		if (z instanceof Flammable)
		{
			z.takeDamage(20);
		}
		else
		{	
			z.takeDamage(10);
		}
	}

	@Override
	public void newLife() 
	{
		this.life = 20;
	}

}
