package proj5;
import java.io.*;
import java.util.*;
/**
 * Project5.java
 * @version 12/8/2012
 * @author Eliot Carney-Seim <eliot2@umbc.edu>
 * @Lab CMSC 202 - Spring 2012
 * @section 5
 * @Assistance nope
 * 
 * @Class_Invariants: none
 */
public class Project5 
{
	/******************** README ********************/
	//In regards to commented-out text, if it's using 3 forward-slashes (///) 
	//it means that those are used for testing, otherwise the text of for
	//clarifications.
	
	/******************** instance variables *********************************/
	private static FileInputStream file_in = null; 
	private static File file_out = null;
	private static Scanner fileScanner_in = null;
	protected static PrintWriter fileScanner_out = null;    

	/********************     main     ***************************************/
	/**
  * @param args City_of_Origin, min. speed, max speed, max cars, in & out file.
	 * @throws BadArgsAmount 
	 * @throws FileNotFoundException 
	 */
	public static void main(String [] args) 
	throws BadArgsAmountException, FileNotFoundException
	{
		//Perform number of arguments check 
		if (args == null){
			throw new BadArgsAmountException("Args not found.");
		}
		else if( args.length <= 0){
			throw new BadArgsAmountException(
					String.format("File given is empty(%d)." +
					"Should be %d.", 0, 6));
		}
		else if( args.length != 6){
			throw new BadArgsAmountException(
					String.format("Incorrect argument amount" +
					"(%d)." + "Should be %d.", args.length, 6));
		}
		
		//the following try/catch code is condensed for organization's sake.
		//test for input file
		try{
			file_in = new FileInputStream(args[4]);
				fileScanner_in = new Scanner(file_in);}
		catch (FileNotFoundException e){
			System.err.println("File not found in input " + e.getMessage());
            	System.exit(-1);}
		
		//test for output file
        try{
                file_out = new File(args[5]);
                fileScanner_out = new PrintWriter(file_out);}
        catch (FileNotFoundException e) {
        throw new MissingFileException("Unable to create log file \"" + args[5] + "\"");
        }
		
		//constructing the train, once file tests have been passed.
		Train train = new Train(args[0],  Integer.valueOf(args[1]), 
			    Integer.valueOf(args[2]), Integer.valueOf(args[3]));
		//This for loop essentially runs the rest of the program.
		while(fileScanner_in.hasNextLine())
		{
			String type_holder = fileScanner_in.nextLine();
			//if the next action being read is ADDCAR. . .
			if(type_holder.equals("ADDCAR")){
				addcar_helper(train);
			}
			else if(type_holder.equals("LOAD")){
				load_helper(train);
			}
			else if(type_holder.equals("PRINT")){
				train.PRINT();
			}
			else if(type_holder.equals("QUIT")){
				Project5.fileScanner_out.println("\nQUIT");
				Project5.fileScanner_out.close();
				System.exit(-1);
			}
			else if(type_holder.equals("UNLOAD")){
				unload_helper(train);
			}
			else if(type_holder.equals("DEPART")){
				train.DEPART(fileScanner_in.nextLine());
			}
			else if(type_holder.equals("ARRIVE")){
				train.ARRIVE();
			}
			else if(type_holder.equals("SPEEDUP")){
				train.SPEEDUP(Integer.valueOf(fileScanner_in.nextLine()));
			}
			else if(type_holder.equals("SLOWDOWN")){
				train.SLOWDOWN(Integer.valueOf(fileScanner_in.nextLine()));
			}
			else if(type_holder.equals("REMOVECAR"))
				train.REMOVECAR(Integer.valueOf(fileScanner_in.nextLine()));
			else{Project5.fileScanner_out.print("Project 5 - main:69 " +
					"METHOD OUT OF ORDER");
				fileScanner_out.close();
				System.exit(-1);
			}
			
		}
		//ALL TESTING BELOW THIS POINT*****************************************
		/*//make a train
		Train test = new Train();
		//make a person
		Person test_man = new Person(0, "123-12-1234", "Joe Cafe", 18 );
		//make a box car
		Boxcar<Person> test_box = new Boxcar<Person>();
		//add a box car to the train
		test.ADDCAR(test_box);
		//add a person to the specified box car
		test_box.load_onto(test_man.getBox_number(), test_man);
		//print out the first person in the first box car
		System.out.println(test.getTrain_list().get(0)
		.getLoad_list().get(0).toString());*/

		fileScanner_out.close();
	}


	/******************** helper methods *************************************/
	
	/**
	 * Will add a boxcar to the train's List list of boxcars, unless
	 * an improper or no type of boxcar is given, then an error is printed
	 * to the out file and the system exits.
	 * 
	 * @param train The train object to be updated.
	 * @return train The updated train object.
	 */
	private static void addcar_helper(Train train) {
		//
		Project5.fileScanner_out.print("\nADDCAR " );
		//Put the item in the following line into a temp variable. . .
		String type_holder = fileScanner_in.nextLine();
		Integer max_carts = Integer.valueOf(fileScanner_in.nextLine());
		Project5.fileScanner_out.print("\n"+type_holder + " ");
		Project5.fileScanner_out.print(max_carts);
		
			//and see if that temp. variable is for person or cargo.
			if(type_holder.equals("PERSON")){
				//a preliminary object, of person or cargo, is sent to the
				//boxcar's constructor, so that it has a placeholder
				//type. Another method looks at this first to know what
				// the appropriate type boxcar contains.
				train.ADDCAR(new Boxcar<Person>(max_carts, 
						new Person("-1", null, 0)));
			}
			else if(type_holder.equals("CARGO")){
				
				train.ADDCAR(new Boxcar<Cargo>(max_carts, 
						new Cargo("-1", 0, 0, 0, 0)));
			}
			else{
				System.err.println("Error in adding boxcar type!" +
						"Tried to add of type: " + type_holder);
				fileScanner_out.close();
				System.exit(-1);
			}
		
	}
	
	/**
	 * This helper method grabs all the necessary variables for a given element
	 * It will also use a separate method to test for ID unique-ness.
	 * the out file will be updated with the command, if the element given
	 * is not unique, the destination boxcar number is changed to -1, and if 
	 * train's LOAD method gets the -1, then it won't add the element to the 
	 * boxcar.
	 * 
	 * @param train The train instance.
	 * @return train With added element, unless given element was not found.
	 */
	@SuppressWarnings("unchecked")
	private static void load_helper(Train train) {
		Project5.fileScanner_out.print("\nLOAD");
		//Grab command for person or cargo and print it to out file.
		String type_holder = fileScanner_in.nextLine();
		Project5.fileScanner_out.print("\n"+type_holder + " ");
		//If grabbed command is a person. . .
		if(type_holder.equals("PERSON")){
			//Get the boxcar and person's ID, which should be next in file.
			int boxcar_ID = Integer.valueOf(fileScanner_in.nextLine());
			Project5.fileScanner_out.print(boxcar_ID + " ");
			
			String unique_ID = fileScanner_in.nextLine();
			//test, if not unique, true, set boxcar_ID to -1, 
			//meaning train.LOAD will trash it.
			if(!Project5.<Cargo>unique_tester(train.getBoxcar_list()
					.get(boxcar_ID).getElement_list(), unique_ID))
			{boxcar_ID = -1;}
			//Send the grabbed and remaining file inputs to train's LOAD method
			Person temp_person = new Person(unique_ID, 
					fileScanner_in.nextLine(), 
					Integer.valueOf(fileScanner_in.nextLine()));
			Project5.fileScanner_out.print(temp_person.toString());
			train.<Person>LOAD(boxcar_ID, temp_person);}
		//if grabbed command is a cargo. . .
		else if(type_holder.equals("CARGO")){
			//Get the boxcar and cargo's ID, which should be next in file.
			int boxcar_ID = Integer.valueOf(fileScanner_in.nextLine());
			Project5.fileScanner_out.print(boxcar_ID + " ");
			
			String unique_ID = fileScanner_in.nextLine();
			//test, if not unique, true, set boxcar_ID to -1, 
			//meaning train.LOAD will trash it.
			if(!Project5.<Cargo>unique_tester(train.getBoxcar_list()
					.get(boxcar_ID).getElement_list(), unique_ID))
			{boxcar_ID = -1;}
			//Send the grabbed and remaining file inputs to train's LOAD method
			Cargo temp_cargo = new Cargo(unique_ID, 
					Integer.valueOf(fileScanner_in.nextLine()),
					Integer.valueOf(fileScanner_in.nextLine()),
					Integer.valueOf(fileScanner_in.nextLine()),
					Integer.valueOf(fileScanner_in.nextLine()));
			Project5.fileScanner_out.print(temp_cargo.toString());
			train.<Cargo>LOAD(boxcar_ID, temp_cargo);}
		else{
			try{
			throw new RuntimeException("\nNo Person or Cargo given to loader,"+
					" type_holder: " + type_holder);} 
			catch(RuntimeException e)
			{
				Project5.fileScanner_out.println(e);
				Project5.fileScanner_out.close();
				System.exit(-1);
			}
		}
	}
	
	/**
	 * @Description Grabs the proper parameters for train's UNLOAD method. 
	 * @param <T> extends {@link Distinguishable}
	 * @param train object to unload.
	 */
	private static <T extends Distinguishable> void unload_helper(
			Train train){Project5.fileScanner_out.print("\nUNLOAD");
		//Grab command for boxcar ID.
		int boxcar_ID = Integer.valueOf(fileScanner_in.nextLine());
		String element_ID = fileScanner_in.nextLine();
		Project5.fileScanner_out.printf(" %s %s",boxcar_ID,element_ID);
		train.<T>UNLOAD(boxcar_ID, element_ID);
	}
	
	/******************** interface methods **********************************/
	/**
	 * @Description This method will cycle through all of the given List's 
	 * elements, searching for one element with the same ID as the given. 
	 * This only works if the given List's elements extend Distinguishable, an 
	 * interface with a method that returns the element's ID.
	 * 
	 * @param <T> A generic type given, important for it's Distinguishable.
	 * @param element_list The list of elements containing an ID to compare.
	 * @param unique_ID The ID for the element that we want to add to boxcar.
	 * @return If a duplicate is found, will return false, else returns true.
	 */
	private static <T extends Distinguishable> boolean unique_tester(
			List<T> element_list, String unique_ID)
	{
		for(T element: element_list)
		{
			if(element.getUnique_ID().equals(unique_ID))
			{return false;
			}
		}
		return true;
	}
}
