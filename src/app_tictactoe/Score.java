/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 18, 2017
 */

package app_tictactoe;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class Score. It indicates the date of a won game
 * as well as the winner
 */
public class Score implements Serializable
{ 
	
	/** The winner. */
	private String winner ;
	
	/** The day number. */
	private int dayNumber ;	
	
	/**
	 * Instantiates a new score.
	 *
	 * @param winner the winner
	 */
	public Score(String winner)
	{
		this.winner = winner ;
		//Date.getTime returns the current date as a long equal to the amount of milliseconds since 1970
		//we don't care about miliseconds, we just want days, so we divide by 1000 milliseconds, 60 seconds, 60 minutes, 24 hours to get a value in days
		this.dayNumber = (int)(new Date().getTime()/(1000*60*60*24)) ;
	}
	
	/**
	 * Gets the day number.
	 *
	 * @return the day number
	 */
	public int getDayNumber()
	{
		return this.dayNumber ;
	}
	
	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public String getWinner()
	{
		return this.winner ;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy") ;
		Date day = new Date((long)dayNumber*(1000*60*60*24)) ;
		return dateformat.format(day) + " -- " + winner   ;
	}

}
