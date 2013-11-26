// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class Army
{
    int[] armies;
    int capacity, remaining;
    
    public Army()
    {
	armies = new int[12];
	armies[0] = 1;
	armies[1] = 1;
	armies[2] = 1;
	armies[3] = 2;
	armies[4] = 3;
	armies[5] = 4;
	armies[6] = 4;
	armies[7] = 4;
	armies[8] = 5;
	armies[9] = 8;
	armies[10] = 1;
	armies[11] = 6;
	capacity = remaining = 40;
    }

    public Army(int[] source)
    {
	armies = new int[12];
	for(int i=0; i<source.length; i++)
	{
	    armies[i] = source[i];
	    capacity += source[i];
	}
	remaining = capacity;
    }

    public int getRemaining()
    {
	return remaining;
    }

    public int getCapacity()
    {
	return capacity;
    }

    public boolean deallocatePiece(int index)
    {
	remaining++;
	switch(index)
	{
	    case 0:
		if(armies[0] < 1)
		{
		    armies[0]++;
		    return true;
		}
		return false;
	    case 1:
		if(armies[1] < 1)
		{
		    armies[1]++;
		    return true;
		}
		return false;
	    case 2:
		if(armies[2] < 1)
		{
		    armies[2]++;
		    return true;
		}
		return false;
	    case 3:
		if(armies[3] < 2)
		{
		    armies[3]++;
		    return true;
		}
		return false;
	    case 4:
		if(armies[4] < 3)
		{
		    armies[4]++;
		    return true;
		}
		return false;
	    case 5:
		if(armies[5] < 4)
		{
		    armies[5]++;
		    return true;
		}
		return false;
	    case 6:
		if(armies[6] < 4)
		{
		    armies[6]++;
		    return true;
		}
		return false;
	    case 7:
		if(armies[7] < 4)
		{
		    armies[7]++;
		    return true;
		}
		return false;
	    case 8:
		if(armies[8] < 5)
		{
		    armies[8]++;
		    return true;
		}
		return false;
	    case 9:
		if(armies[9] < 8)
		{
		    armies[9]++;
		    return true;
		}
		return false;
	    case 10:
		if(armies[10] < 1)
		{
		    armies[10]++;
		    return true;
		}
		return false;
	    case 11:
		if(armies[11] < 6)
		{
		    armies[11]++;
		    return true;
		}
		return false;
	    default:	return false;
	}
    }

    public boolean deallocatePiece(String rank)
    {
	if(translateRank(rank) != -1)
	{
	    deallocatePiece(translateRank(rank));
	    return true;
	}
	return false;
    }

    public boolean deallocatePiece(char rank)
    {
	if(translateRank(rank) != -1)
	{
	    deallocatePiece(translateRank(rank));
	    return true;
	}
	return false;
    }

    public boolean allocatePiece(int index)
    {
	if(armies[index] > 0)
	{
	    armies[index]--;
	    remaining--;
	    return true;
	}
	return false;
    }

    public boolean allocatePiece(String rank)
    {
	if(translateRank(rank) != -1)
	{
	    allocatePiece(translateRank(rank));
	    return true;
	}
	return false;
    }

    public boolean allocatePiece(char rank)
    {
	if(translateRank(rank) != -1)
	{
	    allocatePiece(translateRank(rank));
	    return true;
	}
	return false;
    }

    private int translateRank(String rank)
    {
	char charRank = '0';
	rank = rank.toUpperCase();
	if(rank.equals("FLAG"))
	{
	    charRank = 'F';
	}
	else if(rank.equals("MARSHAL"))
	{
	    charRank = '1';
	}
	else if(rank.equals("GENERAL"))
	{
	    charRank = '2';
	}
	else if(rank.equals("COLONEL"))
	{
	    charRank = '3';
	}
	else if(rank.equals("MAJOR"))
	{
	    charRank = '4';
	}
	else if(rank.equals("CAPTAIN"))
	{
	    charRank = '5';
	}
	else if(rank.equals("LIEUTENANT"))
	{
	    charRank = '6';
	}
	else if(rank.equals("SERGEANT"))
	{
	    charRank = '7';
	}
	else if(rank.equals("MINER"))
	{
	    charRank = '8';
	}
	else if(rank.equals("SCOUT"))
	{
	    charRank = '9';
	}
	else if(rank.equals("SPY"))
	{
	    charRank = 'S';
	}
	else if(rank.equals("BOMB"))
	{
	    charRank = 'B';
	}
	return translateRank(charRank);
    }

    private int translateRank(char rank)
    {
	int retval = -1;
	switch(rank)
	{
	    case 'F':	retval = 0;	break;
	    case '1':	retval = 1;	break;
	    case '2':	retval = 2;	break;
	    case '3':	retval = 3;	break;
	    case '4':	retval = 4;	break;
	    case '5':	retval = 5;	break;
	    case '6':	retval = 6;	break;
	    case '7':	retval = 7;	break;
	    case '8':	retval = 8;	break;
	    case '9':	retval = 9;	break;
	    case 'S':	retval = 10;	break;
	    case 'B':	retval = 11;	break;
	}
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
		    case 0:	options += "F,";	break;
		    case 1:	options += "1,";	break;
		    case 2:	options += "2,";	break;
		    case 3:	options += "3,";	break;
		    case 4:	options += "4,";	break;
		    case 5:	options += "5,";	break;
		    case 6:	options += "6,";	break;
		    case 7:	options += "7,";	break;
		    case 8:	options += "8,";	break;
		    case 9:	options += "9,";	break;
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
    
    @Override
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
	retval += armies[ 0] + " Flags";
	return retval;
    }
}