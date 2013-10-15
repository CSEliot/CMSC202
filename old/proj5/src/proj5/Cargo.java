package proj5;
/**
 * Cargo.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * 
 * @Class_Invariants: none
 */
public class Cargo implements Comparable<Cargo>, Distinguishable
{
	/******************** instance variables *********************************/
	private String cargo_ID;
	private int weight;
	private int height;
	private int width;
	private int length;

	/******************** core methods ***************************************/
	public Cargo(String cargo_ID, int weight, int height, 
			int width, int length) {
		this.cargo_ID = cargo_ID;
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}

	@Override
	public int compareTo(Cargo c) {
		return this.cargo_ID.compareToIgnoreCase(c.cargo_ID);
	}
	/******************** getters/setters ************************************/
	public String getCargo_ID() {
		return cargo_ID;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public String toString()
	{
		String str = "";
		try{
			str =String.format("ID:%-10s  " +
					"Weight:%-10d   " +
					"Dimensions: %dx%dx%d", getCargo_ID(), 
					getWeight(), getHeight(), getWidth(), getLength());
		}
		catch(Exception e)
		{
			str = String.format("%10s%d%d%d%d", getCargo_ID(), 
					getWeight(), getHeight(), getWidth(), getLength());
			System.err.println("Cargo parameters exceed length: " + e);
		}
	
		return str;
	}

	/******************** interface methods **********************************/
	@Override
	public String getUnique_ID() {
		return getCargo_ID();
	}
	
	
	
	
	

}
