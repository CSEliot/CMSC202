package lab9;

public class Student extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int id;

	 
	
	public Student(String name, Integer id)
	{
		this.name = name;
		this.id = id;
		
		if(name == null || id == null)
		{
			throw new IllegalArgumentException("Name or Id is null.");
		}
	}

	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
}
