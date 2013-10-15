package lab4;

public class Rectangle 
{

	private Point upperLeft, lowerLeft, lowerRight, upperRight;     
	
	public Rectangle (Point upperLeft, Point lowerLeft, Point lowerRight, Point upperRight)
	{
	  this.upperLeft = upperLeft;
	  this.lowerLeft = lowerLeft;
	  this.lowerRight = lowerRight;
	  this.upperRight = upperRight;
	  
	}
	
	public double getLength()
	{
		double length = upperLeft.distance(upperRight);
		return length;
	} 
	
	public double getWidth()
	{
		double width = upperLeft.distance(lowerLeft);
		return width;
	}  
	public double getArea()
	{
		double area = getWidth()*getLength(); //(upperLeft.distance(lowerLeft)) * (upperLeft.distance(upperRight));
		return area;	
		
	}  
	
	public double getPerimeter()
	{
		double perimeter = getWidth()*2 + getLength()*2; //(upperLeft.distance(lowerLeft))*2 + (upperLeft.distance(upperRight)*2);
		return perimeter;
	}   
	
	
	 
	// constructor to copy a Rectangle in Rectangle class, which
	// will use the constructor from the Point class
	public Rectangle(Rectangle original)
	{
	    upperLeft = new Point(original.upperLeft);
	    upperRight = new Point(original.upperRight);
	    lowerLeft = new Point(original.lowerLeft);
	    lowerRight = new Point(original.lowerRight);
	    // Finish the rest of the code for another
	    // three instance variables
	} 
}
