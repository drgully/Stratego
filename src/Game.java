// David Gully
// Valdosta State University
// CS 3410 Data Structures, Dr. Loew
// Stratego Project
// November 26, 2013

import java.util.Scanner;
import java.io.*;

public class Game
{
    static int turn = 0;
    static String status;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //If save game exists, load it
        Scanner saveGame;
        Board myBoard = new Board();
        try
        {
            saveGame = new Scanner(new BufferedReader(new FileReader("./Game.save")));
            turn = saveGame.nextInt();
            status = saveGame.nextLine();
            status = saveGame.nextLine();
            while(saveGame.hasNext())
            {
                String rank = saveGame.next();
                //System.out.printf("*%s*\n",rank);
                String team = saveGame.next();
                int row = saveGame.nextInt();
                int column = saveGame.nextInt();
                myBoard.setPiece(new GamePiece(rank.charAt(0), team), row, column);
            }
	    System.out.print("Loaded saved game.\n");
	    handleTurn(myBoard,turn);
        }
        catch(FileNotFoundException err)
        {
	    System.out.print("No saved game found. Please place pieces.\n");
            Army blueArmy = new Army();
            Army redArmy = new Army();
            placePieces(myBoard, blueArmy, "Blue");
	    placePieces(myBoard, redArmy, "Red");
	    handleTurn(myBoard,0);
        }
    }

    public static void setBarriers(Board myBoard)
    {
	// Handled in Board class
    }

    private static void defaultSet(Board myBoard, String team)
    {
        if(team.equals("Red"))
        {
            myBoard.setPiece(new GamePiece('S', "Red"), 6, 0);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 1);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 2);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 3);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 4);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 5);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 6);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 7);
            myBoard.setPiece(new GamePiece('9', "Red"), 6, 8);
            myBoard.setPiece(new GamePiece('8', "Red"), 6, 9);
            myBoard.setPiece(new GamePiece('8', "Red"), 7, 0);
            myBoard.setPiece(new GamePiece('8', "Red"), 7, 1);
            myBoard.setPiece(new GamePiece('8', "Red"), 7, 2);
            myBoard.setPiece(new GamePiece('8', "Red"), 7, 3);
            myBoard.setPiece(new GamePiece('7', "Red"), 7, 4);
            myBoard.setPiece(new GamePiece('7', "Red"), 7, 5);
            myBoard.setPiece(new GamePiece('7', "Red"), 7, 6);
            myBoard.setPiece(new GamePiece('7', "Red"), 7, 7);
            myBoard.setPiece(new GamePiece('6', "Red"), 7, 8);
            myBoard.setPiece(new GamePiece('6', "Red"), 7, 9);
            myBoard.setPiece(new GamePiece('6', "Red"), 8, 0);
            myBoard.setPiece(new GamePiece('6', "Red"), 8, 1);
            myBoard.setPiece(new GamePiece('5', "Red"), 8, 2);
            myBoard.setPiece(new GamePiece('5', "Red"), 8, 3);
            myBoard.setPiece(new GamePiece('5', "Red"), 8, 4);
            myBoard.setPiece(new GamePiece('5', "Red"), 8, 5);
            myBoard.setPiece(new GamePiece('4', "Red"), 8, 6);
            myBoard.setPiece(new GamePiece('4', "Red"), 8, 7);
            myBoard.setPiece(new GamePiece('4', "Red"), 8, 8);
            myBoard.setPiece(new GamePiece('3', "Red"), 8, 9);
            myBoard.setPiece(new GamePiece('3', "Red"), 9, 0);
            myBoard.setPiece(new GamePiece('2', "Red"), 9, 1);
            myBoard.setPiece(new GamePiece('1', "Red"), 9, 2);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 3);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 4);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 5);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 6);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 7);
            myBoard.setPiece(new GamePiece('B', "Red"), 9, 8);
            myBoard.setPiece(new GamePiece('F', "Red"), 9, 9);
        }
        else if(team.equals("Blue"))
        {
            myBoard.setPiece(new GamePiece('F', "Blue"), 0, 0);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 1);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 2);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 3);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 4);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 5);
            myBoard.setPiece(new GamePiece('B', "Blue"), 0, 6);
            myBoard.setPiece(new GamePiece('1', "Blue"), 0, 7);
            myBoard.setPiece(new GamePiece('2', "Blue"), 0, 8);
            myBoard.setPiece(new GamePiece('3', "Blue"), 0, 9);
            myBoard.setPiece(new GamePiece('3', "Blue"), 1, 0);
            myBoard.setPiece(new GamePiece('4', "Blue"), 1, 1);
            myBoard.setPiece(new GamePiece('4', "Blue"), 1, 2);
            myBoard.setPiece(new GamePiece('4', "Blue"), 1, 3);
            myBoard.setPiece(new GamePiece('5', "Blue"), 1, 4);
            myBoard.setPiece(new GamePiece('5', "Blue"), 1, 5);
            myBoard.setPiece(new GamePiece('5', "Blue"), 1, 6);
            myBoard.setPiece(new GamePiece('5', "Blue"), 1, 7);
            myBoard.setPiece(new GamePiece('6', "Blue"), 1, 8);
            myBoard.setPiece(new GamePiece('6', "Blue"), 1, 9);
            myBoard.setPiece(new GamePiece('6', "Blue"), 2, 0);
            myBoard.setPiece(new GamePiece('6', "Blue"), 2, 1);
            myBoard.setPiece(new GamePiece('7', "Blue"), 2, 2);
            myBoard.setPiece(new GamePiece('7', "Blue"), 2, 3);
            myBoard.setPiece(new GamePiece('7', "Blue"), 2, 4);
            myBoard.setPiece(new GamePiece('7', "Blue"), 2, 5);
            myBoard.setPiece(new GamePiece('8', "Blue"), 2, 6);
            myBoard.setPiece(new GamePiece('8', "Blue"), 2, 7);
            myBoard.setPiece(new GamePiece('8', "Blue"), 2, 8);
            myBoard.setPiece(new GamePiece('8', "Blue"), 2, 9);
            myBoard.setPiece(new GamePiece('8', "Blue"), 3, 0);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 1);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 2);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 3);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 4);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 5);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 6);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 7);
            myBoard.setPiece(new GamePiece('9', "Blue"), 3, 8);
            myBoard.setPiece(new GamePiece('S', "Blue"), 3, 9);
        }
    }

    private static boolean handleTurn(Board theBoard, int turn)
    {
        String team;
        boolean playOn = true;
        do
        {
            if(turn%2 == 0)
            {
                team = "Blue";
            }
            else
            {
                team = "Red";
            }
            System.out.printf("\nTurn %d: %s's Move\n", turn, team);
            System.out.print("1: View (B)oard\n");
            System.out.print("2: Move (P)iece\n");
            System.out.print("3: (N)o move\n");
            System.out.print("4: (S)urrender\n");
	    System.out.print("5: (E)xit and Save\n");
	    System.out.print("Enter choice: ");
            switch(input.next().charAt(0))
            {
                case '1': 
                case 'B':
		case 'b':
		    System.out.println(theBoard.getOutput(team));
		    break;
		case '2': 
                case 'P':
		case 'p':
		    switch(handleMove(theBoard, team))
		    {
			case 1:
			    playOn = false;
			    break;
			case 0:
			    clear();
			    turn++;
			    break;
			default:
			    System.out.println("Failed to move piece.");
			    break;
		    }
		    break;
		case '3': 
                case 'N':
		case 'n':
		    System.out.print("Confirm No Move 'YES': ");
		    if(input.next().equals("YES"))
		    {
			clear();
			turn++;
		    }
		    break;
		case '4': 
                case 'S':
		case 's':
		    System.out.print("Surrender must be confirmed with 'YES': ");
		    if(input.next().equals("YES"))
		    {
			System.out.print("\n" + team + " team surrenders! ");
			if(turn%2 == 0)
			{
			    team = "Red";
			}
			else
			{
			    team = "Blue";
			}
			System.out.println(team + " team wins! Thanks for playing.");
			playOn = false;
		    }
		    break;
		case '5': 
                case 'E':
		case 'e':
		    saveFile(theBoard, turn);
		    System.out.println("\nGame saved. Thanks for playing.");
		    playOn = false;
		    break;
		default:
		    System.out.println("Invalid command.");
		    break;
            }
        } while(playOn);
	return playOn;
    }

    private static boolean saveFile(Board myBoard, int turn)
    {
        //Ideally, Board would actually do the translate of itself into a storable chunk.
        //This also assumes Board::length and Board::width.
        PrintWriter saveFile;
        try
        {
            saveFile = new PrintWriter(new FileWriter("./Game.save"));
            saveFile.println(turn);
            saveFile.printf("%s",status);
            for(int i=0; i<10; i++)
            {
                for(int j=0; j<10; j++)
                {
                    Piece at = myBoard.getPiece(i,j);
                    if((at.getType() != ' ') && (at.getType() != '#'))
                    {
                        saveFile.printf("\n%s %s %d %d", at.getType(), at.getTeam(), i, j);
                    }
                }
            }
            saveFile.close();
        }
        catch(IOException err)
        {
            return false;
        }
        return true;
    }

    private static int handleMove(Board theBoard, String team)
    {
	System.out.print("\nEnter row of Piece to move: ");
	int r = Integer.parseInt(""+input.next().charAt(0));
	System.out.print("Enter column of Piece to move: ");
	int c = Integer.parseInt(""+input.next().charAt(0));
	if((r<0) || (r >9) || (c<0) || (c>9))
	{
	    System.out.print("\nOut of bounds. ");
	    return -1;
	}
	Location start = new Location(c,r);
	if(theBoard.getPiece(start).getTeam().equals(team) == false)
	{
	    System.out.print("\nBelongs to other team. ");
	    return -1;
	}
	if((theBoard.getPiece(start).getType() == '#') ||
	   (theBoard.getPiece(start).getType() == 'B') ||
	   (theBoard.getPiece(start).getType() == 'F') ||
	   (theBoard.getPiece(start).getType() == ' '))
	{
	   System.out.print("\nNot movable. ");
	   return -1; 
	}
	System.out.printf("Found piece (%c).\n", theBoard.getPiece(start).getType());
	System.out.print("\nEnter row to move to: ");
	int y = Integer.parseInt(""+input.next().charAt(0));
	System.out.print("Enter column to move to: ");
	int x = Integer.parseInt(""+input.next().charAt(0));
	if((y<0) || (y >9) || (x<0) || (x>9))
	{
	    System.out.print("\nOut of bounds. ");
	    return -1;
	}
	Location stop = new Location(x,y);
	GamePiece movePiece = new GamePiece(theBoard.getPiece(start).getType(),
		theBoard.getPiece(start).getTeam());
	if(!movePiece.isMoveValid(start,stop))
	{
	    System.out.print("\nInvalid move attempt. ");
	    return -1;
	}
	if(start.equals(stop))
	{
	    System.out.print("\nCannot capture own piece. ");
	    return -1;
	}
	if(theBoard.getPiece(start).getType() == '9')
	{
	    if(!start.sameRow(stop))
	    {
		if((!start.sameColumn(stop)))
		{
		    System.out.print("\nCannot move diagonally. ");
		    return -1;
		}
	    }
	    int xStart = start.getX();
	    int xStop = stop.getX();
	    int yStart = start.getY();
	    int yStop = stop.getY();
	    if(start.getX() > stop.getX())
	    {
		xStart = stop.getX();
		xStop = start.getX();
	    }
	    if(start.getY() > stop.getY())
	    {
		yStart = stop.getY();
		yStop = start.getY();
	    }
	    for(int i=xStart+1; i<xStop; i++)
	    {
		if(theBoard.getPiece(start.getY(), i).getType() != ' ')
		{
		     System.out.print("\nScouts can not pass over objects. ");
		     return -1;
		}
	    }
	    for(int i=yStart+1; i<yStop; i++)
	    {
		if(theBoard.getPiece(i, start.getX()).getType() != ' ')
		{
		     System.out.print("\nScouts can not pass over objects. ");
		     return -1;
		}
	    }
	    if(theBoard.getPiece(stop).getType() != ' ')
	    {
		switch(movePiece.interact(theBoard.getPiece(stop)))
		{
		    case 2: System.out.println(team + " moved piece from " + 
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Won combat against (%c).\n",
				    theBoard.getPiece(stop).getType());
			    if(theBoard.getPiece(stop).getType() == 'F')
			    {
				System.out.println(team + " wins the game!");
				return 1;
			    }
			    theBoard.getPiece(stop).setType(movePiece.getType());
			    theBoard.getPiece(stop).setTeam(movePiece.getTeam());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    case 1: System.out.println(team + " moved piece from " +
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Lost combat against (%c).\n",
				    theBoard.getPiece(stop).getType());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    case 0: System.out.println(team + " moved piece from " +
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Lost combat against (%c) in a draw.\n",
				    theBoard.getPiece(stop).getType());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    default: System.out.print("\nInvalid interaction behavior. ");
			     return -1;
		}
	    }
	    else
	    {
		System.out.println(team + " moved piece from " + start.toString() +
			" to " + stop.toString() + ".");
		theBoard.getPiece(stop).setType(movePiece.getType());
		theBoard.getPiece(stop).setTeam(movePiece.getTeam());
		theBoard.getPiece(start).setType(' ');
		theBoard.getPiece(start).setTeam(" ");
		return 0;
	    }
	}
	else if(start.isAdjacent(stop))
	{
	    if(theBoard.getPiece(stop).getType() == ' ')
	    {
		theBoard.getPiece(stop).setType(movePiece.getType());
		theBoard.getPiece(stop).setTeam(movePiece.getTeam());
		theBoard.getPiece(start).setType(' ');
		theBoard.getPiece(start).setTeam(" ");
		System.out.println(team + " moved piece from " + start.toString() +
			" to " + stop.toString() + ".");
		return 0;
	    }
	    else
	    {
		switch(movePiece.interact(theBoard.getPiece(stop)))
		{
		    case 2: System.out.println(team + " moved piece from " +
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Won combat against (%c).\n",
				    theBoard.getPiece(stop).getType());
			    if(theBoard.getPiece(stop).getType() == 'F')
			    {
				System.out.println(team + " wins the game!");
				return 1;
			    }
			    theBoard.getPiece(stop).setType(movePiece.getType());
			    theBoard.getPiece(stop).setTeam(movePiece.getTeam());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    case 1: System.out.println(team + " moved piece from " +
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Lost combat against (%c).\n",
				    theBoard.getPiece(stop).getType());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    case 0: System.out.println(team + " moved piece from " +
			    start.toString() + " to " + stop.toString() + ".");
			    System.out.printf("Lost combat against (%c) in a draw.\n",
				    theBoard.getPiece(stop).getType());
			    theBoard.getPiece(start).setType(' ');
			    theBoard.getPiece(start).setTeam(" ");
			    return 0;
		    default: System.out.print("\nInvalid interaction behavior. ");
			     return -1;
		}
	    }
	}
	else
	{
	    return -1;
	}
    }

    private static void placePieces(Board theBoard, Army pieces, String team)
    {
	int cap = pieces.getCapacity();
	int rem = pieces.getRemaining();
	while(rem >= 0)
	{
	    System.out.println("\n" + team + " has " + rem + " pieces left.");
	    System.out.println("1: View (B)oard");
	    System.out.println("2: View (A)rmy");
	    if(rem > 0)
	    {
		System.out.println("3: (D)efault Setup");
		System.out.println("4: (P)lace Piece");
	    }
	    if(rem < cap)
	    {
		System.out.println("5: (R)emove Piece");
	    }
	    if(rem == 0)
	    {
		System.out.println("6: (C)onfirm Setup");
	    }
	    System.out.print("Enter choice: ");
	    switch(input.next().charAt(0))
	    {
		case '1':
		case 'B':
		case 'b':
		    System.out.println(theBoard.getOutput(team));
		    break;
		case '2':
		case 'A':
		case 'a':
		    System.out.println(outputArmy(pieces,team));
		    break;
		case '3':
		case 'D':
		case 'd':
		    defaultSet(theBoard, team);
		    rem=0;
		    break;
		case '4':
		case 'P':
		case 'p':
		    if(placeHandler(theBoard,pieces,team) == 1)
		    {
			rem--;
		    }
		    break;
		case '5':
		case 'R':
		case 'r':
		    if(removeHandler(theBoard,pieces,team) == 1)
		    {
			rem++;
		    }
		    break;
		case '6':
		case 'C':
		case 'c':
		    clear();
		    return;
	    }
	}
    }

    public static String outputArmy(Army army, String team)
    {
	return "\n" + team + "'s remaining pieces\n" + army.toString();
    }

    public static int placeHandler(Board theBoard, Army army, String team)
    {
	System.out.printf("Choose a piece (%s): ", army.getPieceList());
	char piece = Character.toUpperCase(input.next().charAt(0));
	System.out.print("Enter a row to place: ");
	int r = Integer.parseInt(""+input.next().charAt(0));
	if((r<0)||(r>9))
	{
	    System.out.println("Out of bounds.");
	    return 0;
	}
	System.out.print("Enter a column to place: ");
	int c = Integer.parseInt(""+input.next().charAt(0));
	if((c<0)||(c>9))
	{
	    System.out.println("Out of bounds.");
	    return 0;
	}
	Location loc = new Location(c,r);
	if(theBoard.getPiece(loc).getType() == ' ')
	{
	    if((team.equals("Blue")) && (r>3))
	    {
		System.out.println("Cannot place piece. "
			+ "Blue's starting area is contained by the first four rows(0-3).");
		return 0;
	    }
	    else if((team.equals("Red")) && (r<6))
	    {
		System.out.println("Cannot place piece. "
			+ "Red's starting area is contained by the last four rows(6-9).");
		return 0;
	    }
	    else
	    {
		if(!army.allocatePiece(piece))
		{
		    System.out.println("Could not allocate piece.");
		    return 0;
		}
		theBoard.getPiece(loc).setTeam(team);
		theBoard.getPiece(loc).setType(piece);
		return 1;
	    }
	}
	else
	{
	    System.out.println("Cannot place piece. Location occupied.");
	    return 0;
	}
    }

    public static int removeHandler(Board theBoard, Army army, String team)
    {
	int r, c;
	if(army.getCapacity() == army.getRemaining())
	{
	    System.out.println("No armies to remove.");
	    return 0;
	}
	else
	{
	    System.out.print("Enter row of piece to remove: ");
	    r = Integer.parseInt(""+input.next().charAt(0));
	    if((r<0)||(r>9))
	    {
		System.out.println("Out of bounds.");
		return 0;
	    }
	    System.out.print("Enter column of piece to remove: ");
	    c = Integer.parseInt(""+input.next().charAt(0));
	    if((c<0)||(c>9))
	    {
		System.out.println("Out of bounds.");
		return 0;
	    }
	    Location loc = new Location(c,r);
	    if(!theBoard.getPiece(loc).getTeam().equals(team)||
		    (theBoard.getPiece(loc).getType() == ' ')||
		    (theBoard.getPiece(loc).getType() == '#'))
	    {
		System.out.println("Could not remove piece.");
		return 0;
	    }
	    else
	    {
		army.deallocatePiece(theBoard.getPiece(loc).getType());
		theBoard.getPiece(loc).setType(' ');
		theBoard.getPiece(loc).setTeam(" ");
		return 1;
	    }		
	}
    }

    private static void clear()
    {
	for(int i=0; i<100; i++)
	{
	    System.out.println();
	}
    }
}