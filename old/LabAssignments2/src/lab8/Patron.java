package lab8;

public class Patron implements Comparable{
	

	Name name;
	int rmNum;
	
	public Patron(String first, String last, int rmNum)
	{
		name = new Name(first, last);
		this.rmNum = rmNum;
		
	}
	
	public String toString()
	{
		return name.toString() + ": " + rmNum;
	}
		
	

	public int compareTo(Object otherObject)
	{
		Patron otherPatron = (Patron) otherObject;
		
		if(this.name.compareTo(otherPatron.name) == 0 )
		{	
			return ((Integer)this.rmNum).compareTo((Integer)otherPatron.rmNum);
		}
		else
		{
			return this.name.compareTo(otherPatron.name);
		}
	}

}
