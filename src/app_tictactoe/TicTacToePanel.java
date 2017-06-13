/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.BorderLayout;
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

import ressources.Ressources;

public class TicTacToePanel extends JPanel
{
	GamePanel gamePanel = new GamePanel() ;
	Game game ;
	boolean isVSAI ;
	JButton newGame = new JButton("New Game") ;
	JCheckBox vsAI = new JCheckBox() ;
	public TicTacToePanel() 
	{
		isVSAI=false ;
//		setPreferredSize(new Dimension(300,600)); 
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(15,15,15,15);
		
		gc.gridx = 0;
		gc.gridy = 0;
		add((gamePanel),gc);
		newGame.addActionListener(new NewGameListener());
		newGame.setFont(Ressources.DEFAULT_FONT);
		gc.gridx = 0;
		gc.gridy = 1;
		
	
	
		JPanel newGameAIpanel = new JPanel ();
		newGameAIpanel.setLayout(new BorderLayout());
		newGameAIpanel.add((newGame),BorderLayout.WEST);
		vsAI.addActionListener(new vsAIListener());
		newGameAIpanel.add((vsAI),BorderLayout.EAST);
		gamePanel.newGame(isVSAI);
		add((newGameAIpanel),gc);
	
	}
	
	class NewGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			gamePanel.newGame(isVSAI); ;
		}
		
	}
	
	class vsAIListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
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
