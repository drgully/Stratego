public class Barrier extends Piece
{
	public Barrier()
	{
	}

	public Barrier(char newType, String newTeam)
	{
	}

	public boolean isMoveValid(Location start, Location stop)
	{
	}

	public int interact(Piece other)
	{
	}

	public String[] getOutput()
	{
		String[] retval = new String[4];
		retval[0] = retval[1] = retval[2] = retval[3] = "XXXX";
		return retval;
	}

	public String toString()
	{
	}
}
