package lab4;

public class Point 
{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	
	public Point(Point original)
	{
		this.x = original.x;
		this.y = original.y;
	}
	
	public int getX()  
	{  
		return x;  
	}  
	
	public int getY()  
	{  
		return y;  
	}  
	
	public double distance ( Point otherPoint)
	{
		double x1 = this.x;
		double y1 = this.y;
		double x2 = otherPoint.x;
		double y2 = otherPoint.y;
		
		
	    return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
}
