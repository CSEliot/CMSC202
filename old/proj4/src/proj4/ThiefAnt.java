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
public class ThiefAnt extends Ant {

	protected ThiefAnt() {
		super(25, 15, "Thief Ant");
	}

	@Override
	public void attack(Game g) 
	{
		

	}
	@Override
	public void takeDamage(int amount) 
	{
		life -= amount;
	}
	
	@Override
	public void takeDamage(int amount, Zombie zombie) 
	{
		
		zombie.takeDamage(amount);
		life -= amount;
	}

	@Override
	public void newLife() 
	{
		this.life = 25;
	}

}
