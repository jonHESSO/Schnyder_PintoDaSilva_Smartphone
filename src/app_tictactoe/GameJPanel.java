/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 23, 2017
 */

package app_tictactoe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.* ;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import ressources.Ressources;

public class GameJPanel extends JPanel
{
	private JButton[][] space = new JButton[3][3];
	private String versus ;
	private Game game ;
	private int[] index ;
	private int player ;
	
	public GameJPanel(String versus)
	{
		this.versus = versus ;
		this.player = 1 ;
		setPreferredSize(Ressources.TICTACTOE_APP_JPANEL_DIMENSION); 
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
		this.game = new Game(this.versus) ;
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
			player*=-1 ;
		} catch (Exception e)
		{
//			e.printStackTrace();
		}
		
		
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
			index = getIndex((JButton)e.getSource()) ;
			play() ;
			game.showMatrix();
			System.out.println(game.hasWinner());
			if (game.hasWinner())
			{
				JOptionPane.showMessageDialog(null, "Winner is "+game.getWinner());
			}
		}
		
	}

}
