package lab2;

import java.util.Scanner;

public class ScannerInput {


	
	public static void main(String[] args) {


	    Scanner input = new Scanner(System.in);
        
	    int age;
	    
        
	    System.out.printf("Enter name, first, then last:");
        
	    String firstName = input.next();
	    String lastName  = input.nextLine();
        
	    System.out.printf("\nNOW, please enter age:");
	    age = input.nextInt();
        
	    System.out.printf("\nGPA: ");
	    float gpa = input.nextFloat();
	    
	    System.out.printf("\nCampus ID: ");
	    String campusID = input.next();
	    
	    System.out.printf("\nYou Entered:\n Firstname: %s\n Lastname: %s\n Age: %d\n" +
	    		" GPA: %.2f\n ID: %s\n\n", firstName, lastName, age, gpa, campusID);
		
	    
	    
	    /*
	    firstName = args[0];
	    lastName = args[1];
	    age = args[2];
	    System.out.printf("\nYou Entered:\n%s %s %s\n", firstName, lastName, age);
        */
                       
		
	}

}
