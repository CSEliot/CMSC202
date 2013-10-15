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
public class CitronellaAnt extends Ant{

	protected CitronellaAnt() 
	{
		super(20, 25, "Citronella Ant");
	}

	@Override
	public void attack(Game g) 
	{
		Zombie z = g.getHorde().elementAt(0);
		z.takeDamage(10);
	}

	@Override
	public void newLife() {
		// TODO Auto-generated method stub
		
	}

}
