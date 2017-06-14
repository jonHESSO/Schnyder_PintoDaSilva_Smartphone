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
import java.io.File;
import java.io.IOException;

import javax.swing.*;


import ressources.Ressources;
import ressources.Serializer;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePanel. It contains a game, and a grid
 * displaying the game. Each cell is clickable to add
 * a move. The player can play against a human, or
 * againts a computer (pretty easy to beat)
 */
public class GamePanel extends JPanel
{
	
	/** The tictactoe app jpanel dimension. */
	private final Dimension TICTACTOE_APP_JPANEL_DIMENSION = new Dimension(300,300) ;

	/** The cells. */
//	private JButton[][] cells = new JButton[3][3];
	private JLabel[][] cells = new JLabel[3][3];
	
	JPanel cellPanel ;


	
	/** The game. */
	protected Game game ;
	
	/** The current player. */
	private int currentPlayer ;
	
	/** The bot. */
	private TicTacToeAI bot ;
	
	/** The flag indicating if it is VSAI. */
	private boolean isVSAI ;
	
	/** The scores path. */
	private String scoresPath = Ressources.TICTACTOE_SERIALISATION ;
	
	/** The scores. */
	private TicTacToeStats scores ;

	/**
	 * Instantiates a new game panel.
	 */
	public GamePanel()
	{
		
		this.currentPlayer = 1 ;
		loadStats();
		setPreferredSize(TICTACTOE_APP_JPANEL_DIMENSION); 
		setLayout(new GridLayout(3,3));
		
		
		

		
		
		
//		cellPanel = new JPanel() ;
//		cellPanel.setBackground( new Color(255, 0, 0, 20) );
//		setOpaque(false);
//		setBackground(new Color(0,0,0,1));
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				cells[i][j] = new JLabel() ;
				cells[i][j].setOpaque(false);
				cells[i][j].setBackground(new Color(0,0,0));
//				cells[i][j].setBorderPainted(false);
//				cells[i][j].setContentAreaFilled(false);
				cells[i][j].addMouseListener(new MoveListener());
				add(cells[i][j]);
			}
		}
		
	}

	/**
	 * Display move.
	 *
	 * @param cell the played cell
	 * @param currentPlayer the current player
	 */
	private void displayMove(int[] cell, int currentPlayer)
	{
		int row = cell[0] ;
		int column = cell[1] ;
		String currentPlayerName = null ;
		ImageIcon icon = null ;
		switch (currentPlayer)
		{
		case -1 :
			icon = new ImageIcon(Ressources.DATAPATH+"data/Icons/tictactoe/o.png") ;
			currentPlayerName = "O" ;
			break ;
		case 1 :
			icon = new ImageIcon(Ressources.DATAPATH+"data/Icons/tictactoe/x.png") ;
			currentPlayerName = "X" ;
			break ;
		}
//		this.cells[cell[0]][cell[1]].setText(currentPlayerName);
		this.cells[row][column].setIcon(icon);
//		this.cells[row][column].setOpaque(false);
//		this.cells[row][column].repaint() ;
//		Ressources.MAINFRAME.reloadCenterPanel();
//		this.repaint();
//		this.getParent().repaint();
	}

	/**
	 * New game.
	 *
	 * @param isVSAI true/false
	 */
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
				cells[i][j].setIcon(null) ;
			}
		}
	}
	
	/**
	 * Play.
	 *
	 * @param cell the played cell
	 */
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

	/**
	 * Play move.
	 *
	 * @param cell the played cell
	 * @throws Exception the cell is already played
	 */
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
	
	/**
	 * Play VS player 2.
	 *
	 * @param cell the played cell
	 */
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

	/**
	 * Play VSAI.
	 *
	 * @param cell the played cell
	 */
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

	/**
	 * Test game status.
	 */
	private void testGameStatus()
	{
		if (game.getStatus()!=0)
		{
			displayFinishedGame() ;
		}
	}

	/**
	 * Display that the game is finished.
	 */
	private void displayFinishedGame()
	{
		String result = "" ;
		switch (game.getStatus())
		{
		case -1 :
			if (isVSAI==true)
			{
				result = "AI wins" ;
			}
			else
			{
				result = "Player2 wins" ;
			}
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
		JOptionPane.showMessageDialog(Ressources.MAINFRAME, result,"Resultat", 1);

	}
	
	/**
	 * Save score.
	 */
	private void saveScore()
	{
		Serializer.serializableObject(Ressources.TICTACTOES_STATS, scoresPath);
	}
	
	/**
	 * Save score if  P2/AI wins.
	 */
	private void saveScoreP2()
	{
		if (isVSAI==true)
		{
			Ressources.TICTACTOES_STATS.AIWins();
		}
		else
		{
			Ressources.TICTACTOES_STATS.P2Wins();
		}
		saveScore() ;
		
	}
	
	/**
	 * Save score if P1 wins.
	 */
	private void saveScoreP1()
	{
		if (isVSAI==true)
		{
			Ressources.TICTACTOES_STATS.P1WinsVAI();
		}
		else
		{
			Ressources.TICTACTOES_STATS.P1WinsVP();
		}
		saveScore() ;
	}

	/**
	 * Gets the cell index.
	 *
	 * @param clickedCell the clicked cell
	 * @return the cell index [][]
	 */
	private int[] getCell(JLabel clickedCell)
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
	
	/**
	 * Load stats.
	 */
	private void loadStats()
	{
		File stats = new File(scoresPath) ;
		if(stats.exists()!=true)
		{
				Serializer.serializableObject(new TicTacToeStats(), scoresPath);
		}
		Ressources.TICTACTOES_STATS = (TicTacToeStats) Serializer.deserializableObject(scoresPath) ;

	}


	/**
	 * The listener interface for receiving move events.
	 * The class that is interested in processing a move
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addMoveListener<code> method. When
	 * the move event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * This listener is added to the game panel and plays the
	 * selected cell when clicked (unless it is already played)
	 *
	 * @see MoveEvent
	 */
	private class MoveListener extends MouseAdapter{

		/**
		 * Mouse clicked.
		 *
		 * @param e the event
		 */
		public void mouseClicked(MouseEvent e)
		{
			int[] cell =  getCell((JLabel)e.getSource()) ;
			if (game.getStatus()!=0) 
			{
				return ;
			}
			else
			{
				play(cell) ;
			}


		}
//	            @Override
//	            public void mouseEntered(MouseEvent event){
//	                JButton buton = (JButton)event.getSource();
//	                buton.setContentAreaFilled(false);  //when hoovered it will show borders and fill area.
//	        }
	}

}
