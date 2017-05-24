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
	private boolean hasWinner ;
	private boolean isADraw ;
	private int status ;

	public Game(){
		this.playField = new int[3][3] ;
		this.hasWinner = false ;
		this.isADraw = false ;
		this.status = 0 ;
	}

	public void addMove(int row, int col, int player) throws Exception
	{
		if (this.playField[row][col] != 0)
		{
			throw new Exception("This field is already played") ;
		}
		else
		{
			this.playField[row][col] = player ;
		}
	}

	public int getWinner()
	{
		return winner ;
	}

	public void testStatus()
	{
		isADraw = true ;

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
				if (playField[i][j] == 0) isADraw = false ;

				sumRow+=playField[i][j] ;
				sumCol+=playField[j][i] ;
			}
			sumDiagL+=playField[i][i] ;
			sumDiagR+=playField[i][2-i] ;

			if (Math.abs(sumRow)==3) this.winner = sumRow/3 ;
			if (Math.abs(sumCol)==3) this.winner = sumCol/3 ;
			if (Math.abs(sumDiagL)==3) this.winner = sumDiagL/3 ;
			if (Math.abs(sumDiagR)==3) this.winner = sumDiagR/3 ;			
		}

		if (this.winner != 0) 
		{
			hasWinner = true ;
		}
	}

	public int getStatus()
	{
		testStatus() ;
		
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
