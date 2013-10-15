package proj5;

import java.util.*;
/**
 * Boxcar.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * @Description This class holds a list of elements, a generic type list.
 * It's parameters include a max element integer and a placeholder boolean.
 * @isPlaceholder This exists to work in tandem with certain methods
 * where it's necessary to know what type this boxcar can hold. So boxcar holds
 * a fake element in it's element list and placeholder = true, and as soon as
 * the first element gets added to the list, if placeholder is true, the 
 * fake element gets removed and palceholder becomes false. If UNLOAD causes
 * element list to be empty, the fake element gets reinserted and placeholder
 * becomes true again.
 * @Class_Invariants: Upon construction, boxcar's element_list is never empty.
 */
public class Boxcar <T extends Comparable<T>>
{
	/******************** README *********************************************/
	//Please see the explanation for placeholder.
	
	/******************** instance variables *********************************/
	private List <T> element_list = new ArrayList <T> ();
	private int max_element;
	private boolean placeholder;

	
	/**
	 * @param max_element
	 * @param element "thing" to add to boxcar.
	 * @invariant placeholder always begins w/ true.
	 */
	public Boxcar(int max_element, T element)
	{
		this.max_element = max_element;
		element_list.add(element);
		placeholder = true;
	}

	/******************** core methods ***************************************/
	/**
	 * After all tests are passed successfully, the element is added to the 
	 * list, if there is a placeholder in the list, it's removed first.
	 * @param element A generic type, a "thing" to become an item transported
	 * within the boxcar.
	 * @return Nothing.
	 */
	public void load_element(T element)
	{
		//if the given element and an element in the boxcar are not of the 
		//same class, throw exception in try/catch block.
		if(!element.getClass().equals(element_list.get(0).getClass()))
		{
			try{ 
				throw new BadTypeInputException(element.getClass(), 
						element_list.get(0).getClass());
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		try{
		if(element_list.size() == max_element)
		{
			throw new FullBoxcarException(max_element);
		}}
		catch(Exception e)
		{
			Project5.fileScanner_out.print("\n" + e);
			return;
		}
		//Boxcar needs a placeholder in the element list so that it knows what
		//type it can take in (ex. cargo, person). If all tests are passed,
		// then before the element is added, the placeholder is removed.
		if(placeholder == true){
			element_list.remove(0);
			placeholder = false;
		}
		element_list.add(element);
	}

	/******************** getters and setters ********************************/
	/**
	 * @return element_list
	 */
	public List<T> getElement_list() 
	{
		return element_list;
	}
	
	/**
	 * @return max_element
	 */
	public int getMax_element() {
		return max_element;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String str = 
		"\n|-----------------------------------|";
		for(T element: element_list )
		{
			str += "\n" + element.toString() + 
			"\n|-----------------------------------|";
		}
		return str;
	}

	/**
	 * @see proj5.Boxcar<T>
	 */
	public boolean isPlaceholder() {
		return placeholder;
	}
}
