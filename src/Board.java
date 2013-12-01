// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

public class Board
{
    Piece first;
    int height, width;
    
    public Board()
    {
        height = width = 10;
        Piece[][] board = new Piece[height][width];
        for(int r = 0; r < height; r++)
        {
	    for(int c = 0; c < width; c++)
            {
                if(((r==4)||(r==5))&&((c==2)||(c==3)||(c==6)||(c==7)))
                {
                    board[r][c] = new Barrier();
                }
		else
		{
		    board[r][c] = new Piece();
		}		
            }
        }
        for(int r = 0; r < height; r++)
        {
            for(int c = 0; c < width; c++)
            {
                if(r > 0)
                {
                    board[r][c].setN(board[r-1][c]);
                }
                if(r < (height-1))
                {
                    board[r][c].setS(board[r+1][c]);
                }
                if(c > 0)
                {
                    board[r][c].setW(board[r][c-1]);
                }
                if(c < width-1)
                {
                    board[r][c].setE(board[r][c+1]);
                }
            }
        }
        first = board[0][0];
    }
    
    public boolean setPiece(Piece data, Location target)
    {
        return setPiece(data, target.getX(), target.getY());
    }

    public boolean setPiece(Piece data, int row, int column)
    {
        if((getPiece(row, column) != null) && (getPiece(row, column).getType() != '#'))
        {
            getPiece(row, column).setTeam(data.getTeam());
            getPiece(row, column).setType(data.getType());
            return true;
        }
        return false;
    }

    public Piece getPiece(Location target)
    {
        return getPiece(target.getY(), target.getX());
    }

    public Piece getPiece(int row, int column)
    {
        Piece at = first;
        for(int i=0; i<row; i++)
        {
            at = at.getS();
        }
        for(int i=0; i<column; i++)
        {
            at = at.getE();
        }
        return at;
    }

    public String getOutput()
    {
        return getOutput("hide");
    }

    @Override
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
        return "\n" + retval;
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
                if(!at.getTeam().equals(hide) && (at.getTeam().length() > 1))
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