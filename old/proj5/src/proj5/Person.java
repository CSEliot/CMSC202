package proj5;
/**
 * Person.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * 
 * @Class_Invariants: none
 */
public class Person implements Comparable<Person>, Distinguishable
{
	/******************** instance variables *********************************/
	private String gov_ID;
	private String name;
	private int age;
	
	/******************** core methods ***************************************/
	public Person(String gov_ID, String name, int age)
	{
		this.age = age;
		this.gov_ID = gov_ID;
		this.name = name;
	}

	public String getGov_ID() 
	{
		return gov_ID;
	}

	@Override
	public int compareTo(Person p) {
		return this.gov_ID.compareToIgnoreCase(p.gov_ID);
	}

	/******************** getters/setters ************************************/
	public void setGov_ID(String gov_ID) 
	{
		this.gov_ID = gov_ID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public String toString()
	{
		String str = "";
		if(getGov_ID().length() > 24 || getName().length() > 24 ){
			str = String.format("ID:%-*s  " +
					"Name:%-*s   " +
					"Age:%d   ", getGov_ID().length(), getGov_ID()
					,getName().length(), getName(), getAge());
		}
		str = String.format("ID:%-10s   " +
				"Name:%-10s   " +
				"Age:%d   ", getGov_ID(), getName(), getAge());
		return str;
	}


	@Override
	public String getUnique_ID() {
		return gov_ID;
	}

}
