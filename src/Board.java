public class Board
{

	public boolean setPiece(Piece data, Location target)
	{
	}

	public boolean setPiece(Piece data, int row, int column)
	{
	}

	public Piece getPiece(Location target)
	{
	}

	public Piece getPiece(int row, int column)
	{
	}

	public Board()
	{
	}

	public String getOutput()
	{
		return getOutput("hide");
	}

	public String toString()
	{
		return getOutput("hide");
	}

	public String getOutput(String hide)
	{
		String[] outputData = getOutputHelper(hide);
		String retval = "";
		for(int i=0; i<outputData.length; i++)
		{
			retval = retval + outputData[i] + "\n";
		}
		return retval;
	}

	private String[] getOutputHelper(String hide)
	{
		String rowBar = " ";

		String[] retval = new String[1 + (4*height) + 1];

		String bar = "-";
		for(int i=0; i<width; i++)
		{
			bar = bar + "-----";
			rowBar = rowBar + "  " + (i%10) + "  ";
		}
		retval[0] = bar;

		for(int i=0;i<height;i++)
		{
			int currentRow = (4*i) + 1;
			int endRow = (4*i) + 4;
			retval[endRow] = bar;
			retval[currentRow] = "|";
			retval[currentRow + 1] = "|";
			retval[currentRow + 2] = "|";

			for(int j=0;j<width;j++)
			{
				Piece at = getPiece(i,j);
				String[] currentPiece = at.getOutput();
				if(!at.getTeam().equals(hide) && (at.getTeam().length() > 0))
				{
					if(!hide.equals("showall"))
					{
						currentPiece[2] = "  ? ";
					}
				}
				retval[currentRow] = retval[currentRow] + currentPiece[0] + "|";
				retval[currentRow + 1] = retval[currentRow + 1] + currentPiece[1] + "|";
				retval[currentRow + 2] = retval[currentRow + 2] + currentPiece[2] + "|";
			}
		}

		for(int i=2; i<retval.length; i+=4)
		{
			retval[i] = retval[i] + " " + (((int)(i/4)) % 10);
		}

		retval[retval.length - 1] = rowBar;
		return retval;
	}

}
