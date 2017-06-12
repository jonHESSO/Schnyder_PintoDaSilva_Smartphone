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
		String scoresPath = Ressources.TICTACTOE_SERIALISATION ;
		TicTacToeStats stats;
			stats = (TicTacToeStats) Serializer.deserializableObject(scoresPath);
			stats.showScoresVAI();
			stats.showRatiosVAI(); 

		
		TestFrame tf = new TestFrame() ;
		tf.setVisible(true);
	}

}
