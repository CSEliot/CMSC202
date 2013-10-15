package lab7;

public class ResidenceDriver 
{
	public static void main(String[] args) 
    {
		System.out.println("House:");
		House house = new House();
		System.out.println(house.toString());
		
		System.out.println("\nApartment:");
		Apartment apartment = new Apartment(2, true);
		System.out.println(apartment.toString());
		
		System.out.println("\nTent:");
		Tent tent = new Tent();
		System.out.println(tent.toString());
	}

}
