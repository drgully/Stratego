// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class Location
{
    private int x,y;
        
    public Location()
    {
	x = y = 0;
    }

    public Location(Location source)
    {
	x = source.getX();
	y = source.getY();
    }

    public Location(int newX, int newY)
    {
	x = newX;
	y = newY;
    }

    public boolean isAdjacent(Location source)
    {
	if(sameRow(source))
	{
	    if(Math.abs(x-source.getX()) == 1)
	    {
		return true;
	    }
	}
	else if(sameColumn(source))
	{
	    if(Math.abs(y-source.getY()) == 1)
	    {
		return true;
	    }
	}
	return false;
    }

    public boolean sameRow(Location source)
    {
	if(source.getY() == y)
	{
	    return true;
	}
	return false;
    }

    public boolean sameColumn(Location source)
    {
	if(source.getX() == x)
	{
	    return true;
	}
	return false;
    }

    public int getX()
    {
	return x;
    }

    public int getY()
    {
	return y;
    }

    public void setX(int data)
    {
	x = data;
    }

    public void setY(int data)
    {
	y = data;
    }
    
    public boolean equals(Location rhs)
    {
	if(rhs.getX() == x && rhs.getY() == y)
	{
	    return true;
	}
	return false;
    }

    @Override
    public String toString()
    {
	return "(" + y + "," + x + ")";
    }
}