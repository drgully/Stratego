// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class Piece
{
    private char type;
    private String team;
    Piece N = null;
    Piece S = null;
    Piece E = null;
    Piece W = null;
    
    public Piece()
    {
	type = ' ';
	team = " ";
    }

    public Piece(Piece source)
    {
	type = source.getType();
	team = source.getTeam();
    }

    public Piece getN()
    {
	return N;
    }

    public Piece getS()
    {
	return S;
    }
    
    public Piece getE()
    {
	return E;
    }

    public Piece getW()
    {
	return W;
    }

    public void setN(Piece adjacent)
    {
	N = adjacent;
    }

    public void setS(Piece adjacent)
    {
	S = adjacent;
    }
    
    public void setE(Piece adjacent)
    {
	E = adjacent;
    }

    public void setW(Piece adjacent)
    {
	W = adjacent;
    }

    public char getType()
    {
	return type;
    }

    public String getTeam()
    {
	return team;
    }

    public void setType(char newType)
    {
	type = newType;
    }

    public void setTeam(String newTeam)
    {
	if((newTeam != null) && (newTeam.length() < 5))
	{
	    if(Character.toUpperCase(newTeam.charAt(0)) == 'R')
	    {
		team = "Red";
	    }
	    else if(Character.toUpperCase(newTeam.charAt(0)) == 'B')
	    {
		team = "Blue";
	    }
	    else if(newTeam.charAt(0) == ' ')
	    {
		team = " ";
	    }
	    else
	    {
		System.out.println("\nError in team assignment.");
	    }
	}
    }

    public String[] getOutput()
    {
	    String[] retval = new String[4];
	    retval[0] = team;
	    while(retval[0].length() < 4)
	    {
		    retval[0] = retval[0] + " ";
	    }
	    retval[1] = "    ";
	    retval[2] = "  " + type + " ";
	    retval[3] = "    ";
	    return retval;
    }

    public boolean isMoveValid(Location start, Location stop)
    {
	return false;
    }

    public int interact(Piece other)
    {
	return -1;
    }
    
     public boolean equals(Piece rhs)
    {
	if(rhs.getType() == type)
	{
	    return true;
	}
	return false;
    }
    
    @Override
     public String toString()
    {
	return "Type: " + type + "\nTeam: " + team;
    }
}