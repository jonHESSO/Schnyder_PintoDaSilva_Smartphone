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

public class Score implements Serializable
{ 
	
	private String winner ;
	private int dayNumber ;	
	
	public Score(String winner)
	{
		this.winner = winner ;
		//Date.getTime returns as a long the amount of milliseconds since 1970
		//we don't care about miliseconds, we just want days, so we divide by 1000 milliseconds, 60 seconds, 60 minutes, 24 hours to get a value in days
		this.dayNumber = (int)new Date().getTime()/(1000*60*60*24) ;
	}
	
	public int getDayNumber()
	{
		return this.dayNumber ;
	}
	
	public String getWinner()
	{
		return this.getWinner() ;
	}

}
