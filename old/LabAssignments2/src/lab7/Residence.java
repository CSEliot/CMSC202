package lab7;

public class Residence 
{
	public int rooms;
	public int walls;
	public boolean washer;
	
	public Residence(int rooms, int walls, boolean washer)
	{
		this.rooms = rooms; 
		this.walls = walls;
		this.washer = washer;
	}
	
	protected boolean hasWasher()
	{
		return washer;
	}
	
	protected double propertyValue()
	{
		return rooms*10000;
	}
	
	protected int numWindows()
	{
		return walls*2;
	}
	public String toString()
	{
		String str = "Number of Rooms: " + rooms +
		             "\nNumber of Walls: " + walls +
		             "\nWasher: "          + washer +
		             "\nNumber of Windows: " + numWindows()+
		             "\nProperty Value: " + propertyValue();
		return str;
	}
	
}
