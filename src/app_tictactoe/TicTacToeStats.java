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

// TODO: Auto-generated Javadoc
/**
 * The Class TicTacToeStats. It contains the total of
 * won games f (either vs player or vs AI)
 */
public class TicTacToeStats implements Serializable
{

	/** The score Versus player. */
	private ArrayList<Score> scoreVP ;
	
	/** The score Vs AI. */
	private ArrayList<Score> scoreVAI ;
	
	/** The dateformat. */
	private DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy") ;

	/**
	 * Instantiates two new stats lists
	 */
	public TicTacToeStats()
	{
		this.scoreVP=new ArrayList<Score>() ;
		this.scoreVAI=new ArrayList<Score>() ;
	}

	/**
	 * Adds the winner.
	 *
	 * @param winner the winner
	 * @param score the score list to which it is added
	 */
	private void addWinner(String winner, ArrayList<Score> score)
	{		
		score.add(new Score(winner));
	}

	/**
	 * AI wins.
	 */
	public void AIWins()
	{
		addWinner("AI", this.scoreVAI) ;
	}

	/**
	 * P2 wins.
	 */
	public void P2Wins()
	{
		addWinner("P2", this.scoreVP) ;
	}

	/**
	 * P1 wins VAI.
	 */
	public void P1WinsVAI()
	{
		addWinner("P1", this.scoreVAI) ;
	}

	/**
	 * P1 wins VP.
	 */
	public void P1WinsVP()
	{
		addWinner("P1", this.scoreVP) ;
	}

	/**
	 * Gets the  win ratios.
	 *
	 * @param scores the score list
	 * @return the total win rate for each day
	 */
	private ArrayList<int[]> getRatiosPerDay(ArrayList<Score> scores)
	{
		ArrayList<int[]> ratios = new ArrayList<int[]>() ;
		int tDay  ;
		int lastIndex = scores.size()-1 ;
		if (scores.size()>=1)
		{
			int lastDay = scores.get(lastIndex).getDayNumber() ;
			int index = 0 ; //current index on the score list
			int ratioIndex = 0 ; //current index of the ratio list
			//sums the number of P1 wins and amount of games for each day
			for (tDay = scores.get(0).getDayNumber(); tDay<= lastDay ; tDay++)
			{
				//new line containing [0] day number [1] total of games played [2] total of P1 wins 
				int[] ratio = new int[3] ;
				//set the day for which the ratio is calculated
				ratio[0] = tDay ;
				//for each line with the same day number as tDay
				//starting at the line following the last one tested (index)
				//the summing stops if the last line of the array is reached
				for (int i=index; i<=lastIndex && scores.get(i).getDayNumber()<=tDay ; i++)
				{				
					//increase the number of games played that day by 1
					ratio[1]++ ;
					if(scores.get(i).getWinner().equals("P1"))
						//add a win to the total wins for the same day
						ratio[2]++ ;
					//the list is already ordered by date, so starting at the top of the list is a waste of time and ressources
					//the index of the last used element is saved instead
					index= i ;

				}
				ratios.add(ratio);
				//when all scores from the same day have been counted, go to the next day
				ratioIndex++ ;
			}
		}
		
		return ratios;
	}

	/**
	 * Winrate VS AI.
	 *
	 * @return the win ratio vs the AI
	 */
	public ArrayList<int[]> winratePerDayVAI()
	{
		return getRatiosPerDay(scoreVAI) ;
	}

	/**
	 * Winrate VP.
	 *
	 * @return the win ratio against Player2
	 */
	public ArrayList<int[]> winratePerdDayVP()
	{
		return getRatiosPerDay(scoreVP) ;
	}

	/**
	 * Show scores in the console
	 *
	 * @param score the scores
	 */
	private void showScores(ArrayList<Score> score)
	{
		for (int i = 0; i < score.size(); i++)
		{
			System.out.println(score.get(i).toString()) ;
		}
	}

	/**
	 * Show scores Vs AI.
	 */
	public void showScoresVAI(){
		showScores(scoreVAI) ;
	}

	/**
	 * Show ratios in the console.
	 *
	 * @param winrates the winrates
	 */
	private void showRatios(ArrayList<int[]> winrates)
	{
		for (int i = 0; i < winrates.size(); i++)
		{
			int[] winrate = (int[])(winrates.get(i)) ; 
			Date day = new Date((long)winrate[0]*(1000*60*60*24)) ;
			System.out.println(dateformat.format(day)+" -- "+winrate[2]+"/"+winrate[1]);
		}
	}

	/**
	 * Show ratios VAI in the console.
	 */
	public void showRatiosVAI()
	{
		showRatios(winratePerDayVAI()) ;
	}

}
