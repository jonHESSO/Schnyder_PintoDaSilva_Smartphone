/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : 24 mai 2017
 */

package app_tictactoe;

public class TicTacToeAI
{
	Game currentGame ;

	public TicTacToeAI(Game game)
	{
		this.currentGame = game ;
	}

	public int[] getBestCell()
	{
		int line ;

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
	
	private int player1CanWin()
	{
		int line = -1 ;
		for (int i = 0; i < currentGame.getGameState().length ; i++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[i]==2)
			{
				line = i ;
			}
		}
		return line ;
		
	}

	private int AICanWin()
	{
		int line = -1 ;
		for (int i = 0; i < currentGame.getGameState().length ; i++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[i]==-2)
			{
				line = i ;
			}
		}
		return line ;
	}

	private int firstAvailableRow()
	{
		int row = 2;
		for (int i = 0; i < 3 ; i++)
		{
			if(firstAvailableCell(i)!=null)
			{
				row = i ;
			}
		}
		return row ;
	}

	private int[] firstAvailableCell(int line)
	{
		int[] cell = new int[2] ;
		for (int i = 0; i < 3; i++)
		{
			if(line/3==0)
			{
				if(currentGame.getPlayField()[line][i]==0)
				{
				cell[0] = line ;
				cell[1] = i ;
				}
			}
			if(line/3==1 && currentGame.getPlayField()[i][line]!=0)
			{
				if(currentGame.getPlayField()[i][line-3]==0)
				{
				cell[0]=i ;
				cell[1]=line-3 ;
				}
			}
			if(line/3==2)
			{
				if (line==6 && currentGame.getPlayField()[i][i]==0)
				{
					cell[0]=i ;
					cell[1]=i ;
				}
				if (line==7 && currentGame.getPlayField()[i][2-i]!=0)
				{
					cell[0]=i ;
					cell[1]=2-i ;
				}

			}
		}
		return cell ;


	}

}
