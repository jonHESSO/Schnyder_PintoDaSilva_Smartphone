/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.* ;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import ressources.Ressources;
import ressources.Serializer;

public class GamePanel extends JPanel
{
	private final Dimension TICTACTOE_APP_JPANEL_DIMENSION = new Dimension(300,300) ;

	private JButton[][] cells = new JButton[3][3];
	protected Game game ;
	private int currentPlayer ;
	private TicTacToeAI bot ;
	private boolean isVSAI ;
	private String scoresPath = Ressources.TICTACTOE_DIRECTORY ;
	private TicTacToeStats scores ;

	public GamePanel()
	{
		this.currentPlayer = 1 ;
		loadStats();
		setPreferredSize(TICTACTOE_APP_JPANEL_DIMENSION); 
		setLayout(new GridLayout(3,3));
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				cells[i][j] = new JButton(" ") ;
				cells[i][j].addMouseListener(new MoveListener());
				//				cells[i][j].setPreferredSize(Ressources.TICTACTOE_APP_FIELD_DIMENSION) ;
				add(cells[i][j]);
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
		this.cells[cell[0]][cell[1]].setText(currentPlayerName);
	}

	public void newGame(boolean isVSAI)
	{
		this.currentPlayer = 1 ;
		this.isVSAI=isVSAI ;
		this.game = new Game() ;
		if (isVSAI == true)
		{
			this.bot = new TicTacToeAI(this.game) ;
		}
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				cells[i][j].setText(" ") ;
			}
		}
	}
	
	public void play(int[] cell)
	{
		if (isVSAI==true)
		{
			playVSAI(cell) ;
		}
		else
		{
			playVSPlayer2(cell) ;
		}
	}

	private void playMove(int[] cell) throws Exception
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
	
	protected void playVSPlayer2(int[] cell)
	{
		try
		{
			playMove(cell) ;
		} catch (Exception e)
		{
//			e.printStackTrace();
		}
	}

	protected void playVSAI(int[] cell)
	{
		try
		{
			playMove(cell) ;
			if (game.getStatus()==0)
			{
				playMove(bot.getBestCell()) ;
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
			saveScoreP2() ;
			break ;
		case 1 : 
			result = "Player1 wins" ;
			saveScoreP1() ;
			break ;
		case 2 : 
			result = "Draw" ;
			break ;

		}
		JOptionPane.showMessageDialog(null, result);

	}
	
	private void saveScore()
	{
		Serializer.serializableObject(scores, scoresPath);
	}
	
	private void saveScoreP2()
	{
		if (isVSAI==true)
		{
			scores.AIWins();
		}
		else
		{
			scores.P2Wins();
		}
		saveScore() ;
		
	}
	
	private void saveScoreP1()
	{
		if (isVSAI==true)
		{
			scores.P1WinsVAI();
		}
		else
		{
			scores.P1WinsVP();
		}
		saveScore() ;
	}

	private int[] getCell(JButton clickedCell)
	{
		int[] cell = new int[2];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (cells[i][j] == clickedCell)
				{
					cell[0]=i ;
					cell[1]=j ;
				}
			}
		}
		return cell ;
	}
	
	private void loadStats()
	{
		File stats = new File(scoresPath) ;
		if(stats.exists()!=true)
		{
				Serializer.serializableObject(new TicTacToeStats(), scoresPath);
		}
		scores = (TicTacToeStats) Serializer.deserializableObject(scoresPath) ;

	}


	private class MoveListener extends MouseAdapter{

		public void mouseClicked(MouseEvent e)
		{
			int[] cell =  getCell((JButton)e.getSource()) ;
			if (game.getStatus()!=0) 
			{
				return ;
			}
			else
			{
				play(cell) ;
			}


		}		
	}

}
