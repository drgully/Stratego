public class Army
{
	public Army()
	{
	}

	public Army(int[] source)
	{
	}

	public int getRemaining()
	{
	}

	public int getCapacity()
	{
	}

	public boolean deallocatePiece(int index)
	{
	}

	public boolean deallocatePiece(String rank)
	{
	}

	public boolean deallocatePiece(char rank)
	{
	}

	public boolean allocatePiece(int index)
	{
	}

	public boolean allocatePiece(String rank)
	{
	}

	public boolean allocatePiece(char rank)
	{
	}

	private int translateRank(String rank)
	{
	}

	private int translateRank(char rank)
	{
	}

	public String toString()
	{
		String retval = "";
		retval += armies[ 1] + " Marshals    Rank 1\n";
		retval += armies[ 2] + " Generals    Rank 2\n";
		retval += armies[ 3] + " Colonels    Rank 3\n";
		retval += armies[ 4] + " Majors      Rank 4\n";
		retval += armies[ 5] + " Captains    Rank 5\n";
		retval += armies[ 6] + " Lieutenants Rank 6\n";
		retval += armies[ 7] + " Sergeants   Rank 7\n";
		retval += armies[ 8] + " Miners      Rank 8\n";
		retval += armies[ 9] + " Scouts      Rank 9\n";
		retval += armies[10] + " Spies\n";
		retval += armies[11] + " Bombs\n";
		retval += armies[ 0] + " Flags\n";
		return retval;
	}

	public String getPieceList()
	{
		String options = "";
		for(int i=0; i<12; i++)
		{
			if(armies[i] > 0)
			{
				switch(i)
				{
				case 0:		options += "F,";	break;
				case 1:		options += "1,";	break;
				case 2:		options += "2,";	break;
				case 3:		options += "3,";	break;
				case 4:		options += "4,";	break;
				case 5:		options += "5,";	break;
				case 6:		options += "6,";	break;
				case 7:		options += "7,";	break;
				case 8:		options += "8,";	break;
				case 9:		options += "9,";	break;
				case 10:	options += "S,";	break;
				case 11:	options += "B,";	break;
				}
			}
		}
		if(options.length() > 1)
		{
			options = options.substring(0,options.length() - 1);
		}
		return options;
	}


}
