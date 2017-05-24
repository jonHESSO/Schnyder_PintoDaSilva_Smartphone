/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 22, 2017
 */

package app_tictactoe;

import java.util.ArrayList;

public class TicTacToeStatsTest
{

	public static void main(String[] args)
	{
		TicTacToeStats stats = new TicTacToeStats() ; 
		stats.AIWins() ;
		stats.P1WinsVAI();
		stats.AIWins();
		stats.showStatsVAI();
		
		TestFrame tf = new TestFrame() ;
		tf.setVisible(true);
	}

}
