/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.* ;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import ressources.Ressources;

public class GameJPanel extends JPanel
{
	private final Dimension TICTACTOE_APP_JPANEL_DIMENSION = new Dimension(300,300) ;
	
	private JButton[][] space = new JButton[3][3];
	private Game game ;
	private int[] index ;
	private int player ;

	public GameJPanel()
	{
		this.player = 1 ;
		setPreferredSize(TICTACTOE_APP_JPANEL_DIMENSION); 
		setLayout(new GridLayout(3,3));
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				space[i][j] = new JButton(" ") ;
				space[i][j].addMouseListener(new MoveListener());
				//				space[i][j].setPreferredSize(Ressources.TICTACTOE_APP_FIELD_DIMENSION) ;
				add(space[i][j]);
			}


		}

	}

	private void displayMove(int[] index, int player)
	{
		String playerName = null ;
		switch (player)
		{
		case -1 :
			playerName = "O" ;
			break ;
		case 1 :
			playerName = "X" ;
			break ;
		}
		this.space[index[0]][index[1]].setText(playerName);
	}

	public void newGame()
	{
		this.player = 1 ;
		this.game = new Game() ;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				space[i][j].setText(" ") ;
			}
		}
	}

	private void play()
	{

		try
		{			
			game.addMove(this.index[0], this.index[1], this.player) ;
			displayMove(index,player) ;
			if(game.getStatus()!=0)
			{

			}
			player*=-1 ;
		} catch (Exception e)
		{
			//			e.printStackTrace();
		}


	}

	private void displayFinishedGame()
	{

	}

	private int[] getIndex(JButton field)
	{
		int[] index = new int[2];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (space[i][j] == field)
				{
					index[0]=i ;
					index[1]=j ;
				}
			}
		}
		return index ;
	}


	class MoveListener extends MouseAdapter{

		public void mouseClicked(MouseEvent e)
		{
			System.out.println("cliked, status is "+game.getStatus());
			if (game.getStatus()!=0) 
			{
				
				return ;
			}
			else
			{
				index = getIndex((JButton)e.getSource()) ;
				play() ;
				System.out.println("played, status is "+game.getStatus());
			}

		}		
	}

}
