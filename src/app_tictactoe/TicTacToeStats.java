/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 17, 2017
 */

package app_tictactoe;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TicTacToeStats implements Serializable
{
	
	private ArrayList<Score> scoreVP ;
	private ArrayList<Score> scoreVAI ;
	
	public TicTacToeStats()
	{
		this.scoreVP=null ;
		this.scoreVAI=null ;
	}
	
	public void addWinner(String winner, ArrayList<Score> score)
	{		
		score.add(new Score(winner));
	}
	
	public void AIWins()
	{
		addWinner("AI", scoreVAI) ;
	}
	
	public void P2Wins()
	{
		addWinner("P2", scoreVP) ;
	}
	
	public void P1WinsVAI()
	{
		addWinner("P1", scoreVAI) ;
	}
	
	public void P1WinsVP()
	{
		addWinner("P1", scoreVP) ;
	}

}
