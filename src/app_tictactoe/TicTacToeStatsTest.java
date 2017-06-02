/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 22, 2017 
 */

package app_tictactoe;

import java.io.IOException;
import java.util.ArrayList;

import ressources.Ressources;
import ressources.Serializer;

public class TicTacToeStatsTest
{

	public static void main(String[] args)
	{
		String scoresPath = Ressources.TICTACTOE_DIRECTORY ;
		TicTacToeStats stats;
		try
		{
			stats = (TicTacToeStats) Serializer.deserializableObject(scoresPath);
			stats.showScoresVAI();
			stats.showRatiosVAI();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} ; 

		
		TestFrame tf = new TestFrame() ;
		tf.setVisible(true);
	}

}
