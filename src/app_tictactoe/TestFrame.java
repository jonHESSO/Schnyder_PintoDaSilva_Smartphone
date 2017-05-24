/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : 23 mai 2017
 */

package app_tictactoe;

import javax.swing.JFrame;

public class TestFrame extends JFrame
{
	public TestFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new TicTacToePanel()) ;
		pack() ;
	}

}
