package lab8;

public class Name implements Comparable{

	String first;
	String last;
	
	
	public Name(String first, String last)
	{
		this.first = first;
		this.last = last;
	}
	
	public String toString()
	{
		String str = first + " " + last;
		return str; 
	}
	
	public void hi()
	{
		
	}
	
	public int compareTo(Object otherObject)
	{
		Name newName = (Name) otherObject;
		if(this.last.compareTo(newName.last) == 0 )
		{	
			return this.first.compareTo(newName.first);
		}
		else
		{
			return this.last.compareTo(newName.last);
		}
		
		/*
		if( this.last.equals(newName.last))
		{
			//if last names are equal.
			return 0;
		}
		else
		{
			if(this.first.equals(newName.first))
			{
				//if first names are equal.
				return 1;
			}
			else
			{
				//if nothing is equal.
				return -1;
			}
		}*/
	
		
	}
}
