/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : 24 mai 2017
 */

package app_tictactoe;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

// TODO: Auto-generated Javadoc
/**
 * The Class TicTacToeAI. It creates a Tic Tac Toe
 * playing bot. It has a realy basic bahaviour.
 */
public class TicTacToeAI
{
	
	/** The current game. */
	Game currentGame ;

	/**
	 * Instantiates a new tic tac toe AI.
	 *
	 * @param game the game
	 */
	public TicTacToeAI(Game game)
	{
		this.currentGame = game ;
	}

	/**
	 * Gets the best cell. If it can win this turn, it will win.
	 * If it can prevent the player from winning this turn, it will.
	 * Else, it just plays the first available cell.
	 * Future developpment would include optimal play base on played cells
	 * , not just win condition, or playing a random available cell if no
	 * win condition is met
	 *
	 * @return the best cell
	 */
	int[] getBestCell()
	{

		//pick the first available cell 
		int[] bestCell = firstAvailableCell(firstAvailableRow()) ;
		
		//if the player could win next turn
		if(player1CanWin()!=-1)
		{
			bestCell = firstAvailableCell(player1CanWin()) ;
		}
		//if the AI can win now
		if(AICanWin()!=-1)
		{
			bestCell = firstAvailableCell(AICanWin()) ;
		}
		
		return bestCell ;

	}
	
	/**
	 * Player 1 can win.
	 *
	 * @return the line where the player could win
	 */
	private int player1CanWin()
	{
		int line = -1 ;
		for (int i = 0; i < currentGame.getGameState().length ; i++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[i]==2)
			{
				return i ;
			}
		}
		return line ;
		
	}

	/**
	 * AI can win.
	 *
	 * @return the line where the AI could win
	 */
	private int AICanWin()
	{
		int line = -1 ;
		for (int i = 0; i < currentGame.getGameState().length ; i++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[i]==-2)
			{
				return i ;
			}
		}
		return line ;
	}

	/**
	 * First available row.
	 *
	 * @return the first available row index
	 */
	private int firstAvailableRow()
	{
		int row = 0 ;
		int[] noAvailableCell = {-1,-1} ;
		for (int i = 0; i < 3 ; i++)
		{
			if(Arrays.equals(firstAvailableCell(i),noAvailableCell)==false)
			{
				return i ;
			}
		}
		return row ;
	}
	

	/**
	 * First available cell.
	 *
	 * @param line the line. The line can be horizontal, vertical or diagonal
	 * @return int[] the index of first available cell in the line
	 */
	private int[] firstAvailableCell(int line)
	{
		int[] cell = {-1,-1};
		boolean availableCell = false ;
		int row = 0 ;
		while (availableCell==false && row<3)
		{
			if(line/3==0)
			{
				if(currentGame.getPlayField()[line][row]==0)
				{
					cell[0] = line ;
					cell[1] = row ;
					availableCell = true ;
				}
			}
			if(line/3==1)
			{
				if(currentGame.getPlayField()[row][line-3]==0)
				{
				cell[0]=row ;
				cell[1]=line-3 ;
				availableCell = true ;
				}
			}
			if(line/3==2)
			{
				if (line==6 && currentGame.getPlayField()[row][row]==0)
				{
					cell[0]=row ;
					cell[1]=row ;
					availableCell = true ;
				}
				if (line==7 && currentGame.getPlayField()[row][2-row]==0)
				{
					cell[0]=row ;
					cell[1]=2-row ;
					availableCell = true ;
				}

			}
			row++ ;
		}
		return cell ;


	}

}
