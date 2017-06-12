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
		setLayout(new FlowLayout());
		add(gamePanel) ;
		newGame.addActionListener(new NewGameListener());
		newGame.setFont(Ressources.DEFAULT_FONT);
		add(newGame);
		vsAI.addActionListener(new vsAIListener());
		add(vsAI) ;
		gamePanel.newGame(isVSAI);
		
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
