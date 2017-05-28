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
	private int currentPlayer ;
	private TicTacToeAI bot ;

	public GameJPanel()
	{
		this.currentPlayer = 1 ;
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

	private void displayMove(int[] cell, int currentPlayer)
	{
		String currentPlayerName = null ;
		switch (currentPlayer)
		{
		case -1 :
			currentPlayerName = "O" ;
			break ;
		case 1 :
			currentPlayerName = "X" ;
			break ;
		}
		this.space[cell[0]][cell[1]].setText(currentPlayerName);
	}

	public void newGame()
	{
		this.currentPlayer = 1 ;
		this.game = new Game() ;
		this.bot = new TicTacToeAI(this.game) ;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				space[i][j].setText(" ") ;
			}
		}
	}

	private void play(int[] cell) throws Exception
	{

		try
		{			
			game.addMove(cell[0], cell[1], this.currentPlayer) ;
			displayMove(cell,currentPlayer) ;
			if(game.getStatus()!=0)
			{
				testGameStatus() ;
			}
			currentPlayer*=-1 ;
		} catch (Exception e)
		{
			throw new Exception("Cell not available") ;
		}


	}

	private void playVSAI(int[] cell)
	{
		try
		{
			play(cell) ;
			if (game.getStatus()==0)
			{
				System.out.println(bot.getBestCell()[0]+" "+bot.getBestCell()[1]);
				play(bot.getBestCell()) ;
			}
		} catch (Exception e)
		{
//			e.printStackTrace();
		}
	}

	private void testGameStatus()
	{
		if (game.getStatus()!=0)
		{
			displayFinishedGame() ;
		}
	}

	private void displayFinishedGame()
	{
		String result = "" ;
		switch (game.getStatus())
		{
		case -1 :
			result = "Player2 wins" ;
			break ;
		case 1 : 
			result = "Player1 wins" ;
			break ;
		case 2 : 
			result = "Draw" ;
			break ;

		}
		JOptionPane.showMessageDialog(null, result);

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
			int[] cell =  getIndex((JButton)e.getSource()) ;
			if (game.getStatus()!=0) 
			{
				return ;
			}
			else
			{
				playVSAI(cell) ;
			}


		}		
	}

}
