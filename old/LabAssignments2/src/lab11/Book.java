package lab11;

public class Book implements Media
{

	String id;
	String artist;
	String title;
	int yearPublished;
	

	
	
	public Book(String id, String artist, String title, int yearPublished) 
	{
		this.artist = artist;
		this.id = id;
		this.title = title;
		this.yearPublished = yearPublished;
	}




	@Override
	public String getCreator() 
	{
		return artist;
	}




	@Override
	public <T> Comparable<T> getId() 
	{
		return (Comparable<T>) id;
	}




	@Override
	public String getTitle() 
	{
		return title;
	}




	@Override
	public int getYear() 
	{
		return yearPublished;
	}
}
