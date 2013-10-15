 package proj5;

import java.util.*;
/**
 * Train.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * 
 * @Class_Invariants: none
 */
public class Train 
{
	/******************** instance variables *********************************/
	private String city_of_origin;
	private String destination_station;
	private Boolean transporting = false;
	private int min_speed;
	private int current_speed = 0;
	private int max_speed;
	private int max_num_boxcar;
	@SuppressWarnings("rawtypes")
	private List <Boxcar> boxcar_list = new  ArrayList <Boxcar> ();  
	
	/******************** core methods ***************************************/
	public Train
	(String city_of_origin, int min_speed, int max_speed, int max_num_boxcar)
	{
		this.city_of_origin = city_of_origin;
		this.max_num_boxcar = max_num_boxcar;
		this.max_speed = max_speed;
		this.min_speed = min_speed;
	}

	/**
	 * Add's a boxcar with a generic type to the train's list.
	 * @param <T> a type of "thing" to determine interaction w/ boxcar.
	 * @param boxcar containing generic type given by project5's helper method.
	 * @return Nothing.
	 */
	@SuppressWarnings("rawtypes")
	public <T extends Comparable> void ADDCAR(Boxcar<?> boxcar)
	{
		if(transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is " +
						"currently en-route. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		boxcar_list.add(boxcar);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends Comparable> void LOAD(int boxcar_ID, T element)
	{
		if(transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is " +
						"currently en-route. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		if(boxcar_ID == -1){
			Project5.fileScanner_out.print(
					"\nWarning: Non-Unique ID given. Action Skipped");
			return;}
		boxcar_list.get(boxcar_ID).load_element(element);
		
	}
	
	/**
	 * Gives full print out of train status and boxcars and elements, if any.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void PRINT()
	{
		String current_action;
		if(transporting == false)
		{current_action = "Stopped at " + city_of_origin;}
		else{current_action = "Traveling from " + city_of_origin + " to " 
			+ destination_station;}
		String train_status = String.format(
		"\nTrain Statistics" +
		"\n|===============[::]-[::]}>=========|" + 
		"\n       Current Speed:    %-3d" + 
		"\n       Minimum Speed:    %-3d" + 
		"\n       Maximum Speed:    %-3d" + 
		"\n       Current Position: %s"  +
		"\n  Current Number of Boxcars: %-3d" + 
		"\n  Maximum Number of Boxcars: %-3d"
		,current_speed, min_speed, max_speed, current_action
		,boxcar_list.size(), max_num_boxcar);
		int i= 0;
		for(Boxcar boxcar: boxcar_list)
		{
			//if boxcar has a placeholder, it is void of any real element,
			//so it is essentially empty.
			if(!boxcar.isPlaceholder()){
			try{Collections.sort(boxcar.getElement_list());
				train_status += "\n Boxcar ID: " + i + boxcar.toString();
			}
			catch(NullPointerException e){ 
				System.err.println("Null pointer to element List: " + e);
			}
			}
			else{
			train_status += "\n|-----------------------------------|" +
							"\n Boxcar ID: " + i +
							" -- Currently w/ no contents." +
							"\n|-----------------------------------|";
			}
			i++;
		}
		Project5.fileScanner_out.println(train_status);
	}

	/**
	 * Makes a number of tests, if all are passed, will unload an element if
	 * it's ID matches the given ID of the intended element to unload.
	 * 
	 * @param <T> element to be removed.
	 * @param boxcar_ID location of boxcar in the list.
	 * @param element_ID Unique ID given to individual elements upen LOADING.
	 * @return Nothing.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends Distinguishable> void UNLOAD(
			int boxcar_ID, String element_ID) {
		if(transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is " +
						"currently en-route. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		//if too large a boxcar ID is given. Also works if boxcar_list.size()=0
		if(boxcar_list.size()-1 < boxcar_ID){
			//If statment is true and the boxcar list is empty. . .
			if(boxcar_list.size()==0){
				try{ 
					throw new BadUnloadTarget("Warning: Train is empty of "+
							"boxcars. Action skipped. ");
				}
				catch(Exception e)
				{
					Project5.fileScanner_out.print("\n" + e);
					return;
				}
			}
			try{ 
				throw new BadUnloadTarget(boxcar_ID, boxcar_list.size());
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		//if boxcar has a placeholder, it is void of any real element,
		//so it is essentially empty. 
		else if(boxcar_list.get(boxcar_ID).isPlaceholder()){
			try{ 
				throw new BadUnloadTarget("Warning: Target boxcar has no " +
						"valid element to unload. Action skipped. ");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		List <T> element_list = boxcar_list.get(boxcar_ID).getElement_list();
		int max_elements = boxcar_list.get(boxcar_ID).getMax_element();
		for(T element: element_list){
			if(element.getUnique_ID().equals(element_ID))
			{
				element_list.remove(element);
				//if the element list in boxcar becomes 0, there is no longer a
				//placeholder in the list, so this current element is sent and
				//a new boxcar is swapped out, with placeholder == true.
				//what the element contains does not matter, only it's type.
				if(element_list.size() == 0){
				boxcar_list.set(boxcar_ID, new Boxcar(max_elements,
						(Comparable) element));
				}
				return;
			}
			
		}
		//If after searching through all the elements, no similarity is found.
		try{ 
			throw new BadUnloadTarget(element_ID, boxcar_ID);
		}
		catch(Exception e)
		{
			Project5.fileScanner_out.print("\n" + e);
			return;
		}
	}

	/**
	 * Changes various variables to reflect the logic of departing
	 * for example: transporting, current speed, and destination.
	 * 
	 * @param destination location given from command file.
	 * @return Nothing.
	 */
	public void DEPART(String destination) {
		Project5.fileScanner_out.print("\nDEPART ");
		if(transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train has already"
						+ " departed. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		destination_station = destination;
		transporting = true;
		current_speed = min_speed;
		Project5.fileScanner_out.print(destination_station);
	}

	/**
	 * Alters variables to reflect logic in arriving.
	 * city of origin becomes destination city.
	 * destination city is nullified.
	 * @return Nothing.
	 */
	public void ARRIVE() {
		Project5.fileScanner_out.print("\nARRIVE");
		if(!transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train has not yet"
						+ " departed. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		city_of_origin = destination_station;
		transporting = false;
		current_speed = 0;
		destination_station = null;
	}

	/**
	 * Increases speed of train, but not beyond the max.
	 * @param up_speed
	 * @return Nothing.
	 */
	public void SPEEDUP(int up_speed){
		Project5.fileScanner_out.printf("\nSPEEDUP %d", up_speed);
		if(!transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is not yet "
						+ "en-ruote. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		
		if(current_speed+up_speed>max_speed){
			try{
				throw new SpeedMaxExtentionException(
						current_speed, up_speed, max_speed);
			}
			catch(Exception e){
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		else{current_speed = current_speed +up_speed;}
	}

	/**
	 * Decreases the train's speed, but not past the minimum.
	 * @param down_speed
	 * @return Nothing.
	 */
	public void SLOWDOWN(int down_speed){
		Project5.fileScanner_out.printf("\nSLOWDOWN %d", down_speed);
		if(!transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is not yet "
						+ "en-ruote. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		if(current_speed-down_speed<min_speed){
			try{
				throw new SpeedMinExtentionException(
						current_speed, down_speed, min_speed);
			}
			catch(Exception e){
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		else{current_speed = current_speed-down_speed;}
	}

	/**
	 * Will remove a boxcar from the train's list, but only if the boxcar
	 * contains a placeholder, meaning it's empty, though not technically.
	 * 
	 * @param boxcar_ID the location in the list to be removed.
	 * @return Nothing.
	 */
	public void REMOVECAR(int boxcar_ID) {
		Project5.fileScanner_out.printf("\nREMOVECAR %d", boxcar_ID);
		if(transporting){
			try{ 
				throw new IllogicalActionException("Warning: Train is " + 
						"currently en-ruote. Action skipped.");
			}
			catch(Exception e)
			{
				Project5.fileScanner_out.print("\n" + e);
				return;
			}
		}
		//if the target boxcar Id is too high, out a warning and return.
		if(boxcar_ID > boxcar_list.size()-1){
			Project5.fileScanner_out.print("\nWarning: Target boxcar(%d) is " +
				"out of range(%d). Action skipped.");
			return;
		}
		//if boxcar has a placeholder, it is void of any real element,
		//so it is essentially empty.
		if(boxcar_list.get(boxcar_ID).isPlaceholder()){
			boxcar_list.remove(boxcar_ID);
		}
	}

	/******************** getters/setters ************************************/
	@SuppressWarnings("rawtypes")
	public List<Boxcar> getBoxcar_list() 
	{
		return boxcar_list;
	}
}
	


















