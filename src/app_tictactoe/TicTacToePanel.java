/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ressources.DefaultTextLabel;
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
	
	/** The vs AI label	 */
	JLabel vsAILabel = new DefaultTextLabel("VS AI") ;
	
	JPanel background  ;
	JLabel backgroundLabel ;

	
	/**
	 * Instantiates a new tic tac toe panel.
	 */
	public TicTacToePanel() 
	{
		//starts without an AI
		isVSAI=false ;

//		setPreferredSize(new Dimension(300,600)); 
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(15,15,15,15);
		
		gc.gridx = 0;
		gc.gridy = 0;
		
//		add(background) ;
//		gamePanel.setBackground(new Color(255, 0, 0, 20));
//		add(new AlphaContainer(gamePanel),gc) ;
		background = new JPanel() ;
		backgroundLabel = new JLabel(new ImageIcon(Ressources.DATAPATH+"data/Icons/tictactoe/grille.png")) ;
		background.add(backgroundLabel) ;
		add(background) ;
//		add(new AlphaContainer(gamePanel),gc) ;
		add(gamePanel,gc);

		newGame.addActionListener(new NewGameListener());
		newGame.setFont(Ressources.DEFAULT_FONT);
		gc.gridx = 0;
		gc.gridy = 1;
		
		
	
		JPanel newGameAIpanel = new JPanel ();
		newGameAIpanel.setLayout(new BorderLayout());
		newGameAIpanel.add((newGame),BorderLayout.WEST);
		
		
		vsAI.addActionListener(new vsAIListener());
		newGameAIpanel.add((vsAI),BorderLayout.CENTER);
		newGameAIpanel.add(vsAILabel,BorderLayout.EAST);
		gamePanel.newGame(isVSAI);
		add((newGameAIpanel),gc);
	
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
			gamePanel.newGame(isVSAI);
//			background.repaint();
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
