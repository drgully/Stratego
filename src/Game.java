import java.util.Scanner;
import java.io.*;

public class Game
{
	public static void main(String[] args)
	{
		//If save game exists, load it
		Scanner saveGame = null;
		try
		{
			saveGame = new Scanner(new BufferedReader(new FileReader("./Game.save")));
			turn = saveGame.nextInt();
			status = saveGame.nextLine();
			status = saveGame.nextLine();
			while(saveGame.hasNext())
			{
				String rank = saveGame.next();
				System.out.printf("*%s*\n",rank);
				String team = saveGame.next();
				int row = saveGame.nextInt();
				int column = saveGame.nextInt();
				myBoard.setPiece(new GamePiece(rank.charAt(0), team), row, column);
			}
			//Delete savegame?
		}
		catch(FileNotFoundException err)
		{
			Army redArmy = new Army();
			Army blueArmy = new Army();
			placePieces(myBoard, redArmy, "Red");
			clear();
			placePieces(myBoard, blueArmy, "Blue");
			clear();
		}


	}

	public static void setBarriers(Board myBoard)
	{
	}

	private static void defaultSet(Board myBoard, String team)
	{
		if(team.equals("Red"))
		{
			myBoard.setPiece(new GamePiece('1', "Red"), 6, 0);
			myBoard.setPiece(new GamePiece('2', "Red"), 6, 1);
			myBoard.setPiece(new GamePiece('3', "Red"), 6, 2);
			myBoard.setPiece(new GamePiece('3', "Red"), 6, 3);
			myBoard.setPiece(new GamePiece('4', "Red"), 6, 4);
			myBoard.setPiece(new GamePiece('4', "Red"), 6, 5);
			myBoard.setPiece(new GamePiece('4', "Red"), 6, 6);
			myBoard.setPiece(new GamePiece('5', "Red"), 6, 7);
			myBoard.setPiece(new GamePiece('5', "Red"), 6, 8);
			myBoard.setPiece(new GamePiece('5', "Red"), 6, 9);
			myBoard.setPiece(new GamePiece('5', "Red"), 7, 0);
			myBoard.setPiece(new GamePiece('6', "Red"), 7, 1);
			myBoard.setPiece(new GamePiece('6', "Red"), 7, 2);
			myBoard.setPiece(new GamePiece('6', "Red"), 7, 3);
			myBoard.setPiece(new GamePiece('6', "Red"), 7, 4);
			myBoard.setPiece(new GamePiece('7', "Red"), 7, 5);
			myBoard.setPiece(new GamePiece('7', "Red"), 7, 6);
			myBoard.setPiece(new GamePiece('7', "Red"), 7, 7);
			myBoard.setPiece(new GamePiece('7', "Red"), 7, 8);
			myBoard.setPiece(new GamePiece('8', "Red"), 7, 9);
			myBoard.setPiece(new GamePiece('8', "Red"), 8, 0);
			myBoard.setPiece(new GamePiece('8', "Red"), 8, 1);
			myBoard.setPiece(new GamePiece('8', "Red"), 8, 2);
			myBoard.setPiece(new GamePiece('8', "Red"), 8, 3);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 4);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 5);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 6);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 7);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 8);
			myBoard.setPiece(new GamePiece('9', "Red"), 8, 9);
			myBoard.setPiece(new GamePiece('9', "Red"), 9, 0);
			myBoard.setPiece(new GamePiece('9', "Red"), 9, 1);
			myBoard.setPiece(new GamePiece('S', "Red"), 9, 2);
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
			myBoard.setPiece(new GamePiece('1', "Blue"), 0, 0);
			myBoard.setPiece(new GamePiece('2', "Blue"), 0, 1);
			myBoard.setPiece(new GamePiece('3', "Blue"), 0, 2);
			myBoard.setPiece(new GamePiece('3', "Blue"), 0, 3);
			myBoard.setPiece(new GamePiece('4', "Blue"), 0, 4);
			myBoard.setPiece(new GamePiece('4', "Blue"), 0, 5);
			myBoard.setPiece(new GamePiece('4', "Blue"), 0, 6);
			myBoard.setPiece(new GamePiece('5', "Blue"), 0, 7);
			myBoard.setPiece(new GamePiece('5', "Blue"), 0, 8);
			myBoard.setPiece(new GamePiece('5', "Blue"), 0, 9);
			myBoard.setPiece(new GamePiece('5', "Blue"), 1, 0);
			myBoard.setPiece(new GamePiece('6', "Blue"), 1, 1);
			myBoard.setPiece(new GamePiece('6', "Blue"), 1, 2);
			myBoard.setPiece(new GamePiece('6', "Blue"), 1, 3);
			myBoard.setPiece(new GamePiece('6', "Blue"), 1, 4);
			myBoard.setPiece(new GamePiece('7', "Blue"), 1, 5);
			myBoard.setPiece(new GamePiece('7', "Blue"), 1, 6);
			myBoard.setPiece(new GamePiece('7', "Blue"), 1, 7);
			myBoard.setPiece(new GamePiece('7', "Blue"), 1, 8);
			myBoard.setPiece(new GamePiece('8', "Blue"), 1, 9);
			myBoard.setPiece(new GamePiece('8', "Blue"), 2, 0);
			myBoard.setPiece(new GamePiece('8', "Blue"), 2, 1);
			myBoard.setPiece(new GamePiece('8', "Blue"), 2, 2);
			myBoard.setPiece(new GamePiece('8', "Blue"), 2, 3);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 4);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 5);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 6);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 7);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 8);
			myBoard.setPiece(new GamePiece('9', "Blue"), 2, 9);
			myBoard.setPiece(new GamePiece('9', "Blue"), 3, 0);
			myBoard.setPiece(new GamePiece('9', "Blue"), 3, 1);
			myBoard.setPiece(new GamePiece('S', "Blue"), 3, 2);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 3);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 4);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 5);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 6);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 7);
			myBoard.setPiece(new GamePiece('B', "Blue"), 3, 8);
			myBoard.setPiece(new GamePiece('F', "Blue"), 3, 9);
		}
	}

	private static boolean handleTurn(Board theBoard, int turn)
	{
	}

	private static boolean saveFile(Board myBoard, int turn)
	{
		//Ideally, Board would actually do the translate of itself into a storable chunk.
		//This also assumes Board::length and Board::width.

		PrintWriter saveFile = null;
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
	}

	private static void placePieces(Board theBoard, Army pieces, String team)
	{
	}

	public static String outputArmy(Army army, String team)
	{
	}

	public static int placeHandler(Board theBoard, Army army, String team)
	{
	}

	public static int removeHandler(Board theBoard, Army army, String team)
	{
	}

	private static void clear()
	{
		System.out.print("\033[" + "2J");
	}

}
