package lab7;

public class Apartment extends Residence 
{
	public int story;
	
	public Apartment(int story, boolean washer)
	{
		super(4, 4, washer);
		this.story = story;
	}
	
	protected double propertyValue()
	{
		if(washer = true)
		{
			return rooms*10000+100;
		}
		else
		{
		return rooms*10000;
		}
	}
	
	protected int getStory()
	{
		return story;
	}
	
	
	public String toString()
	{
		
		String str = super.toString() +
		             "\nStory: "      + getStory();
		return str;
	}
	
}
