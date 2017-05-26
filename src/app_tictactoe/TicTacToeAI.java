/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : 24 mai 2017
 */

package app_tictactoe;

public class TicTacToeAI
{
	Game currentGame ;

	public void play(Game game)
	{
		this.currentGame = game ;
	}

	private void testStatus()
	{
		for (int i = 0; i < currentGame.getGameState().length ; i++)
		{
			//if the AI can win now
			if(currentGame.getGameState()[i]==-2)
			{
				playFirstAvailableCell(i) ;
			}
			//if the player could win next turn

		}
	}

	private void playFirstAvailableCell(int state)
	{
		for (int i = 0; i < 3; i++)
		{
		if(state/3==0 && currentGame.getPlayField()[state][i]!=0)
		{
			//row
			return ;
			
		}
		if(state/3==1 && currentGame.getPlayField()[i][state]!=0)
		{
			//column
			return ;
		}
		if(state/3==2)
		{
			//diagonal
			return ;
		}
		}
		

	}

}
