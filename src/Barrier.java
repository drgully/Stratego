// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class Barrier extends Piece
{
    final int ERROR = -1;
    
    public Barrier()
    {
	super.setType('#');
    }

    public Barrier(char newType, String newTeam)
    {
	this();
    }

    @Override
    public boolean isMoveValid(Location start, Location stop)
    {
	return false;
    }

    @Override
    public int interact(Piece other)
    {
	return ERROR;
    }

    @Override
    public String[] getOutput()
    {
	    String[] retval = new String[4];
	    retval[0] = retval[1] = retval[2] = retval[3] = "XXXX";
	    return retval;
    }

    @Override
    public String toString()
    {
	return "";
    }
}