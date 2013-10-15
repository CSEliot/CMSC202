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
public abstract class Ant {

	protected int life;
	protected int cost;
	protected String desc;
	
	protected Ant(int life,int cost, String desc)
	{
		this.life = life;
		this.desc = desc;
		this.cost = cost;
	}
	
	public void takeDamage(int amount, Zombie zombie) 
	{
		life -= amount;
	}

	public int getLife() {
		
		return life;
	}

	public void takeDamage(int amount) 
	{
		life -= amount;
	}
	
	public abstract void attack(Game game);
	
	 /**
     * Will reset the ant's life back to it's preset integer.
     */
	public abstract void newLife();

	public int getCost()
	{
		return cost;
	}

	public String getDesc()
	{
		return desc;
	}
}
