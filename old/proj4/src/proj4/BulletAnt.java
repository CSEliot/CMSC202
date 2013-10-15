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

public class BulletAnt extends Ant {

	protected BulletAnt() 
	{
		super(1, 10, "Bullet Ant");
	}

	@Override
	public void attack(Game g) 
	{
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(25);
	}

	@Override
	public void newLife() 
	{
		this.life = 1;
	}

}
