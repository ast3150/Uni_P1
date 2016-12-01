/* ************************************************************************* *\
*                Programmierung 1 HS 2016 - Serie 4-1                         * 
\* ************************************************************************* */
/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.util.*;

/** A slightly less stupid computer player */
public class ComputerPlayer implements IPlayer
{
	private Token token;

	private Token[][] boardCopy = new Token[VierGewinnt.COLS][VierGewinnt.ROWS];
	
	/**
	 * We try to check what move the other player has made. Then, with a certain probability, the
	 * computer will either make the same move or choose an empty column randomly.
	 * If the other player has not made a move, the computer will chose an empty column randomly.
	 */
	public int getNextColumn( Token[][] board ) {
		for (int col = 0; col < VierGewinnt.COLS; col++) {
			for (int row = VierGewinnt.ROWS - 1; row >= 0; row--) {

				if (board[col][row] != Token.empty && (board[col][row] != this.token) && (boardCopy[col][row] == Token.empty)) {
					// Move made
					if (!isColFull(col, board)) {
						// Can play in this row

						java.util.Random generator = new java.util.Random();
						if (generator.nextInt(100) > 70) {
							// Keep some randomness for good luck
							return getRandomNonFullColumn(board);
						} else {
							// Play same column as other player
							this.boardCopy = board;
							return col;
						}
					} else {
						// Can't play this row, choose empty row randomly
						this.boardCopy = board;
						return getRandomNonFullColumn(board);
					}
				}

			}
		}
		// No moves made, choose empty row randomly
		this.boardCopy = board;
		return getRandomNonFullColumn(board);
	}

	// Same implemenattion as example
	private int getRandomNonFullColumn( Token[][] board) {
		java.util.Random generator = new java.util.Random();
		int randCol = generator.nextInt( board.length );
		int step = 0;
		while ( isColFull( randCol, board ) ) {
			randCol = ( randCol + 1 ) % board.length;
		}
		return randCol;
	}

	private int insertToken( Token[][] board, int column, Token tok )
	{
		for(int i = 0; i < board.length; i++) {
			if(board[column][i].toString() == " ") {
				board[column][i] = tok;
				return i;
			}
		}
		System.exit(1);
		return 99;
	}

	/**
	 * @return true if the column col is already full and false otherwise. 
	 */
	private boolean isColFull( int col, Token[][] board )
	{
		int topRow = board[ col ].length - 1;
		return ( board[ col ][ topRow ] != Token.empty );
	}


	public void setToken( Token token )
	{
		this.token = token;
	}

	public Token getToken()
	{
		return this.token;
	}

	public String getPlayersName()
	{
		return "Random Player";
	}
}
