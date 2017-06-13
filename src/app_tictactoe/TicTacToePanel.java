/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ressources.Ressources;

/**
 * The Class TicTacToePanel.
 */
public class TicTacToePanel extends JPanel
{
	
	/** The game panel. */
	GamePanel gamePanel = new GamePanel() ;
	
	/** The game. */
	Game game ;
	
	/** The is VSAI. */
	boolean isVSAI ;
	
	/** The new game button. */
	JButton newGame = new JButton("New Game") ;
	
	/** The vs AI checkbox. */
	JCheckBox vsAI = new JCheckBox() ;
	
	/**
	 * Instantiates a new tic tac toe panel.
	 */
	public TicTacToePanel() 
	{
		//starts without an AI
		isVSAI=false ;
		setLayout(new FlowLayout());
		add(gamePanel) ;
		newGame.addActionListener(new NewGameListener());
		newGame.setFont(Ressources.DEFAULT_FONT);
		add(newGame);
		vsAI.addActionListener(new vsAIListener());
		add(vsAI) ;
		gamePanel.newGame(isVSAI);
		
	}
	
	/**
	 * The listener for the new game button. Launches a new game in the GamePanel
	 */
	class NewGameListener implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the event
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			gamePanel.newGame(isVSAI); ;
		}
		
	}
	
	/**
	 * The VS AI checkbox listener
	 * Sets the VSAI flag to either true or false
	 * for the next game
	 */
	class vsAIListener implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//checks if the VSAI checkbox is checked
			if(vsAI.isSelected())
			{
				isVSAI = true ;
			}
			else
			{
				isVSAI = false ;
			}
		}
		
	}

}
