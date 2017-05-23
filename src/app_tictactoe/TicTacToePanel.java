/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

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
	GameJPanel gamePanel = new GameJPanel("AI") ;
	Game game ;
	JButton newGame = new JButton("New Game") ;
	public TicTacToePanel() 
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION); 
		setLayout(new FlowLayout());
		add(gamePanel) ;
		newGame.addActionListener(new NewGameListener());
		add(newGame);
		gamePanel.newGame();
		
	}
	
	class NewGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			gamePanel.newGame(); ;
		}
		
	}

}
