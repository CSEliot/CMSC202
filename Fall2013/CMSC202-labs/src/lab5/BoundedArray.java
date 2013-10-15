package lab5;
import java.util.Scanner;

/**
 *	BoundedArray implements an array of integers with values 
 *		between a specified minimum and maximum range.
 *
 *	Class Invariants:
 * 	'minVal' must be less than or equal to 'maxVal'
 *	All values of the array must be in the range
 *		'minVal' and 'maxVal' INCLUSIVE
 *	@author
 *	@version Oct 7th, 2012
 *	@project CMSC 202 - Fall 2012 - Lab #5
 *	@section #
 *
 */
public class BoundedArray {
	private int array[];
	private int minVal;
	private int maxVal;
	
	/**
	 * Assigns the instance variable array reference to 
	 * point to the incoming array reference. Also assigns the 
	 * range values.
	 * Precondition: The input array to the constructor cannot be null.
	 * Precondition: 'minVal' must be less than or equal to 'maxVal'
	 * Precondition: All values of the array must be in the range
	 *               'minVal' and 'maxVal' INCLUSIVE
	 * @param array The input array to be searched on.
	 * @param minVal The minimum allowed value in the array.
	 * @param maxVal The maximum allowed value in the array.
	 */
	public BoundedArray(int[] array, int minVal, int maxVal) {
		
		//Precondition #1 The input array to the constructor cannot be null.
		if(array==null){
			throw new NullPointerException("Constructor precondition " +
					"not met: Input array cannot be null");
		}
		
		//Precondition #2 'minVal' must be less than or equal to 'maxVal'
		if(maxVal<minVal){
			throw new RuntimeException("Constructor precondition " +
					"not met: 'minVal' IS NOT less than or equal to 'maxVal'.");
		}
		

		//
		// Precondition #3 All values of the array must be in the range
		//                  'minVal' and 'maxVal' INCLUSIVE
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] > maxVal || array[i] < minVal)
			{
				System.out.println(array[i]);
				throw new RuntimeException("NOT RIGHT NUMBER INA ARRAY OK?");
			}
			
			
		}
		
		// Initialize the "member instance variables"
		this.array=array;
		this.minVal=minVal;
		this.maxVal=maxVal;
	}
	
	
	/**
	 * Method to determine if element 'x' resides within the array.
	 * Precondition: value of 'x' must be in range 'minVal' and 'maxVal' INCLUSIVE
	 * Postcondition: returns true:   if the array contains 'x'
	 *                returns false:  otherwise
	 * @param x The number to be searched
	 * @return  True if the array contains 'x', false otherwise
	 */
	public boolean contains(int x){
	
		// Check for the 'contains()' preconditions
		for (int i = 0; i < array.length; i++) 
		{
			if(x > maxVal || x < minVal)
			{
				System.out.println(array[i]);
				throw new RuntimeException("NOT RIGHT NUMBER INA ARRAY OK?");
			}
			
			
		}
			
		boolean found=false;
		int i=0;
		while(found==false && i < array.length){
			if(array[i]==x){
				// We found the element at position i
				found = true;
				return found;
			}
			i++;
		}
		// We did not find the element
		return found;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		
		System.out.println("Welcome to the BoundedArray Unit Tester");
		System.out.println("What would you like to test?");
		System.out.println("Case 1:  Constructor array=null");
		System.out.println("Case 2:  Constructor minVal>maxVal");
		System.out.println("Case 3:  Constructor array elements < minVal");
		System.out.println("Case 4:  Constructor array elements > maxVal");
		System.out.println("Case 5:  Constructor General Case (happy path #1)");
		System.out.println("Case 6:  Constructor Edge Case (happy path #2)");
		System.out.println("Case 7:   contains(x), where x < minVal");
		System.out.println("Case 8:   contains(x), where x > maxVal");
		System.out.println("Case 9:   contains(x), where 'x' is found");
		System.out.println("Case 10:  contains(x), where 'x' is not found");
		System.out.println("Case 11:  contains(x), where 'x' equal to 'minVal'");
		System.out.println("Case 12:  contains(x), where x equal to 'maxVal'");
		System.out.print("Please type which test case to run: ");
		int button = input.nextInt();

		System.out.println("--------------------");
		System.out.println("- Case "+button+" Result:");
		System.out.println("--------------------");
		
		/*
		 *Enter test case to check class invariant #2 
		 */
		switch (button)
		{
			case 1:
			{
				// 1:  Constructor array=null
				System.out.println("Passing null array. Expecting error statement.");
				int[] testArray=null;
				BoundedArray b=new BoundedArray(testArray, 0, 100);
			}
			break;
			case 2:
			{
				// 2:  Constructor minVal>maxVal
				System.out.println("Passing minVal>maxVal. Expecting error statement.");
				int[] testArray={1,2,3,4,5};
				BoundedArray b=new BoundedArray(testArray, 10, 9);
			}
			break;
			case 3:
			{
				// 3:  Constructor array elements < minVal
				System.out.println("Passing ARRAY FOR < minVal. Expecting error statement.");
				int[] testArray={1,2,3,4,5};
				BoundedArray b=new BoundedArray(testArray, 3, 4);
			}
			break;
			case 4:
			{
				// 4:  Constructor array elements > maxVal
				System.out.println("Passing ARRAY FOR > maxVal. Expecting error statement.");
				int[] testArray={1,2,3,4,5};
				BoundedArray b=new BoundedArray(testArray, 2, 6);
			}
			break;
			case 5:
			{
				// 5: Constructor General Case (happy path #1)
				System.out.println("General test case for constructor (happy path)");
				int[] testArray={-5,-6,0,-1,3,6,7,-2,2,3,4,7,-8};
				BoundedArray b=new BoundedArray(testArray, -8, 7 	);
				System.out.println("\tBoundedArray object successfully initialized");
			}
			break;
			case 6:
			{
				// 6: Constructor Edge Case (happy path #2)
				System.out.println("Edge case for constructor. Array values " +
					"exactly on range limits");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				System.out.println("\tBoundedArray object successfully initialized");
			}
			break;
			case 7:
			{
				// 7:  contains(x), where x < minVal
				System.out.println("Passing -11 for contains method. Expecting error statement.");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				b.contains(-11);
				System.out.println("\tBoundedArray object successfully initialized");
			}
			break;
			case 8:
			{
				// 8:  contains(x), where x > maxVal
				System.out.println("Passing 9 for contains method. Expecting error statement.");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				b.contains(9);
				System.out.println("\tBoundedArray object successfully initialized");
			}
			break;
			case 9:
			{
				// 9:  contains(x), where 'x' is found
				System.out.println("Passing 2 for contains method. not Expecting error statement.");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				boolean foundIt = b.contains(2);
				System.out.println("Did we find 2? " + foundIt);
			}
			break;
			case 10:
			{
				int[] testArray = {1, 2, 3, 4, 5};
				BoundedArray b=new BoundedArray(testArray,0,8);
				boolean foundIt = b.contains(6);
				System.out.println("Did we find 6? " + foundIt);
				
			}
			break;
			case 11:
			{
				System.out.println("Passing -10 for contains method. not Expecting error statement.");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				boolean foundIt = b.contains(-10);
				System.out.println("Did we find -10? " + foundIt);
			}
			break;
			case 12:
			{
				System.out.println("Passing 8 for contains method. not Expecting error statement.");
				int[] testArray={-5,-9,0,-1,3,6,7,-2,2};
				BoundedArray b=new BoundedArray(testArray,-10,8);
				boolean foundIt = b.contains(8);
				System.out.println("Did we find 8? " + foundIt);
			}
			break;
			default:
				System.out.println("case #"+button+" does not exist"+
					", please type a better number .");
			break;
		}
	}
}

