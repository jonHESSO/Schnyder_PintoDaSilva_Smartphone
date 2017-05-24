/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

public class Game
{
	private int[][] playField ;

	//player1 is 1, player2 is -1 
	private int winner ;
	//flags indicating the state of the game
	private boolean hasWinner ;
	private boolean isADraw ;
	//status indicates if a game is still going [0], won [1] or [-1], or ended in a draw [2]
	private int status ;
	//gameState indicates if a line is won or winnable
	//it sums the value of each row[0-2], column[3-5] and diagonal[6-7]
	//if the sum is 0, there is still a free cell
	//if the sum is 2 or -2, player 1 or player 2 can win the game
	//if the sum is 3 or -3, the game is won
	private int[] gameState ;

	public Game(){
		this.playField = new int[3][3] ;
		this.hasWinner = false ;
		this.isADraw = false ;
		this.status = 0 ;
		this.gameState = new int[8] ;
	}

	public void addMove(int row, int col, int currentPlayer) throws Exception
	{
		if (this.playField[row][col] != 0)
		{
			throw new Exception("This field is already played") ;
		}
		else
		{
			this.playField[row][col] = currentPlayer ;
			setGameState() ;
		}
		
	}

	public int getWinner()
	{
		return winner ;
	}
	
	public int[][] getPlayField()
	{
		return this.playField ;
	}

	private void setStatus()
	{
		isADraw = true ;
		//check for a win
		for (int i = 0; i < gameState.length; i++)
		{
			if(Math.abs(gameState[i])==3)
			{
				hasWinner=true ;
				isADraw = false ;
				winner = gameState[i]/3 ;				
			}
		}
		//check for a draw
		if (hasWinner==false)
		{
			isADraw = true ;
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (playField[i][j]==0)
					{
						isADraw = false ;
					}
				}
			}
		}
	}
	
	private void setGameState()
	{
		int sumRow = 0 ;
		int sumCol = 0 ;
		int sumDiagL = 0 ;
		int sumDiagR = 0 ;

		for (int i = 0; i < 3; i++)
		{
			sumRow = 0 ;
			sumCol = 0 ;

			for (int j = 0; j < 3; j++)
			{
				sumRow+=playField[i][j] ;
				sumCol+=playField[j][i] ;
			}
			gameState[i] = sumRow ;
			gameState[i+3] = sumCol ;
			sumDiagL+=playField[i][i] ;
			sumDiagR+=playField[i][2-i] ;
		}
		gameState[6] = sumDiagL ;
		gameState[7] = sumDiagR ;
		
		setStatus() ;
		
	}
	
	public int[] getGameState()
	{
		return this.gameState ;
	}

	public int getStatus()
	{
		if (status==0) 
		{
			status = 0 ;
		}
		if (isADraw==true)
		{
			status = 2 ;
		}
		if (hasWinner==true)
		{
			status = winner ;
		}
		
		return status ;
	}

	public void showMatrix()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(playField[i][j]+" ") ;
			}
			System.out.println();
		}
	}

}
