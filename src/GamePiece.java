// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class GamePiece extends Piece
{
    final int WIN = 2;
    final int LOSE = 1;
    final int TIE = 0;
    final int ERROR = -1;
    
    public GamePiece()
    {
	super();
    }

    public GamePiece(GamePiece source)
    {
	super(source);
    }

    public GamePiece(char newType, String newTeam)
    {
	super.setType(newType);
	super.setTeam(newTeam);
    }

    @Override
    public boolean isMoveValid(Location start, Location stop)
    {
	if(!start.equals(stop) && super.getType() != 'F' && super.getType() != 'B')
	{
	    return true;
	}
	return false;
    }

    public int interact(GamePiece other)
    {
	return interact((Piece)other);
    }

    @Override
    public int interact(Piece other)
    {
	if(!super.getTeam().equals(other.getTeam()))
	{
	    if(super.getType() == 'B' || super.getType() == 'F' || other.getType() == '#')
	    {
		return ERROR;
	    }
	    if(other.getType() == ' ')
	    {
		return WIN;
	    }
	    if(other.getType() == 'F')
	    {
		return WIN;
	    }
	    if(other.getType() == 'B' && super.getType() != 8)
	    {
		return LOSE;
	    }
	    else if(other.getType() == 'B' && super.getType() == 8)
	    {
		return WIN;
	    }
	    if(super.getType() == other.getType())
	    {
		return TIE;
	    }
	    if(super.getType() == 'S')
	    {
		if(other.getType() == '1')
		{
		    return WIN;
		}
		else
		{
		    return LOSE;
		}
	    }
	    if(super.getType() < other.getType())
	    {
		return WIN;
	    }
	    else
	    {
		return LOSE;
	    }
	}
	return ERROR;
    }

    @Override
    public String toString()
    {
	return "";
    }
}