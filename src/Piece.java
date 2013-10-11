public class Piece
{
	public Piece()
	{
	}

	public Piece(Piece source)
	{
	}

	public Piece getN()
	{
	}

	public Piece getS()
	{
	}

	public Piece getW()
	{
	}

	public Piece getE()
	{
	}

	public void setN(Piece adjacent)
	{
	}

	public void setS(Piece adjacent)
	{
	}

	public void setW(Piece adjacent)
	{
	}

	public void setE(Piece adjacent)
	{
	}

	public char getType()
	{
	}

	public String getTeam()
	{
	}

	public void setType(char newType)
	{
	}

	public void setTeam(String newTeam)
	{
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

	public String toString()
	{
	}

	public boolean equals(Piece rhs)
	{
	}

	public boolean isMoveValid(Location start, Location stop)
	{
	}

	public int interact(Piece other)
	{
	}
}
