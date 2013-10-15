package lab3;

public class Fraction {

	/**
	 * @param args
	 */
	

	private int numerator;
	
	private int denominator;

	public Fraction( int numerator, int denominator)
	{
		//Dividing by zero exception
		if (denominator == 0)
			throw new RuntimeException("Divide By Zero Exception");
		else
		{
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	
	public int getNumerator()
	{
		return numerator;
		
	}

	String str = " \n";
	
	public String toString()
	{
		str += "numerator = " + numerator +" \ndenominator = "+ denominator ;
		return str;
		
	}

	
	public double decimalValue()
	{
	  //Explicitly change the data type of numerator and denominator. Eg. (double)var;
	  //return the decimal value by dividing the numerator and denominator, both converted to double
		return (double)numerator/(double)denominator;
		
	
	}

	
	
	public Fraction multiply( Fraction secondFraction )
	{
		return new Fraction(secondFraction.numerator*this.numerator,secondFraction.denominator*this.denominator);
	    
	}

	public boolean equals(Fraction secondFraction) 
	{
		if ((this.numerator * secondFraction.denominator) == (this.denominator* secondFraction.numerator))
			return true;
		 	
		   	return false;
	}

	
	
	
}

