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
		
		int[] bestCell = new int[2] ;
		for (line = 0; line < currentGame.getGameState().length ; line++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[line]==-2)
			{
				bestCell = searchFirstAvailableCell(line) ;
				return ;
			}
			//if the player could win next turn
			if(currentGame.getGameState()[line]==2)
			{
				searchFirstAvailableCell(line) ;
				return ;
			}
			if(currentGame.getGameState()[line]==1)
			{
				searchFirstAvailableCell(line) ;
				return ;
			}
			if(currentGame.getGameState()[line]==-1)
			{
				searchFirstAvailableCell(line) ;
				return ;
			}
			searchFirstAvailableCell(line) ;
			return ;

		}
	}
	
	private boolean AICanWin()

	private int[] searchFirstAvailableCell(int line)
	{
		int[] cell = new int[2] ;
		for (int i = 0; i < 3; i++)
		{
			if(line/3==0 && currentGame.getPlayField()[line][i]!=0)
			{
				cell[0] = line ;
				cell[1] = i ;
			}
			if(line/3==1 && currentGame.getPlayField()[i][line]!=0)
			{
				cell[0]=i ;
				cell[1]=line-3 ;
			}
			if(line/3==2)
			{
				if (line==6 && currentGame.getPlayField()[i][i]!=0)
				{
					cell[0]=i ;
					cell[1]=i ;
				}
				if (line==6 && currentGame.getPlayField()[i][i]!=0)
				{
					cell[0]=i ;
					cell[1]=2-i ;
				}

			}
		}
		return cell ;


	}

}
